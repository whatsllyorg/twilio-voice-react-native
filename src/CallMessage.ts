/**
 * Copyright © 2022 Twilio, Inc. All rights reserved. Licensed under the Twilio
 * license.
 *
 * See LICENSE in the project root for license information.
 */

import { EventEmitter } from 'eventemitter3';
import type { NativeCallMessageInfo } from './type/CallMessage';
import { InvalidArgumentError } from './error/InvalidArgumentError';

/**
 * CallMessage API is in beta.
 *
 * Provides access to information about a CallMessage, including the call
 * message content, content type, message type, and voice event SID.
 *
 * @public
 */
export class CallMessage extends EventEmitter {
  /**
   * The content of the message which should match the contentType parameter.
   */
  private _content: any;

  /**
   * The MIME type of the content.
   */
  private _contentType: string;

  /**
   * Message type
   */
  private _messageType: string;

  /**
   * An autogenerated id that uniquely identifies the instance of this message.
   * This is not required when sending a message from the SDK as this is autogenerated.
   * But it will be available after the message is sent, or when a message is received.
   */
  private _voiceEventSid?: string;

  /**
   * Constructor for the {@link (CallMessage:class) | CallMessage class}. This should
   * not be invoked by third-party code.
   *
   * @param NativeCallMessageInfo - An object containing all of the data from the
   * native layer necessary to fully describe a callMessage, as well as invoke native
   * functionality for the callMessage.
   *
   * @internal
   */
  constructor(callMessageInfo: NativeCallMessageInfo) {
    super();

    const { content, contentType, messageType } =
      validateCallMessage(callMessageInfo);

    this._content = content;
    this._contentType = contentType;
    this._messageType = messageType;
    this._voiceEventSid = callMessageInfo.voiceEventSid;
  }

  /**
   * Get the content body of the message.
   * @returns the content body of the message.
   */
  getContent(): any {
    return this._content;
  }

  /**
   * Get the MIME type for the message.
   * @returns a string representing the content type of the message.
   */
  getContentType(): string {
    return this._contentType;
  }

  /**
   * Get the message type.
   * @returns a string representing the message type.
   */
  getMessageType(): string {
    return this._messageType;
  }

  /**
   * Get the message SID.
   * @returns
   * - A string representing the message SID.
   * - `undefined` if the call information has not yet been received from the
   *   native layer.
   */
  getSid(): string | undefined {
    return this._voiceEventSid;
  }
}

/**
 * Parse CallMessage values. Used when constructing a CallMessage from the
 * native layer, or by the Call and CallInvite classes when sending a
 * CallMessage.
 *
 * @param message the CallMessage details.
 *
 * @internal
 */
export function validateCallMessage(message: {
  content: any;
  contentType?: string;
  messageType: string;
}) {
  const content = message.content;
  const messageType = message.messageType;

  let contentType = message.contentType;

  if (typeof contentType === 'undefined') {
    contentType = 'application/json';
  }

  if (typeof contentType !== 'string') {
    throw new InvalidArgumentError(
      'If "contentType" is present, it must be of type "string".'
    );
  }

  if (typeof messageType !== 'string') {
    throw new InvalidArgumentError('"messageType" must be of type "string".');
  }

  if (typeof content === 'undefined' || content === null) {
    throw new InvalidArgumentError('"content" must be defined and not "null".');
  }

  return { content, contentType, messageType };
}
