package com.twiliovoicereactnative;

import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import static com.twiliovoicereactnative.TwilioVoiceReactNativeModule.TAG;

public class AndroidEventEmitter {
  private static AndroidEventEmitter instance;
  private ReactApplicationContext context;

  /**
   * Event scopes.
   */
  public static final String CALL_EVENT_NAME = "Call";
  public static final String VOICE_EVENT_NAME = "Voice";

  /**
   * Common.
   */
  public static final String EVENT_KEY_TYPE = "type";
  public static final String EVENT_KEY_ERROR = "error";
  public static final String EVENT_KEY_ERROR_CODE = "code";
  public static final String EVENT_KEY_ERROR_MESSAGE = "message";
  public static final String EVENT_KEY_UUID = "uuid";

  /**
   * Push notification registration.
   */
  public static final String ACTION_FCM_TOKEN_REQUEST = "ACTION_FCM_TOKEN_REQUEST";

  /**
   * Call event types.
   */
  public static final String EVENT_TYPE_CALL_RINGING = "ringing";
  public static final String EVENT_TYPE_CALL_CONNECTED = "connected";
  public static final String EVENT_TYPE_CALL_DISCONNECTED = "disconnected";
  public static final String EVENT_TYPE_CALL_CONNECT_FAILURE = "connectFailure";
  public static final String EVENT_TYPE_CALL_RECONNECTED = "reconnected";
  public static final String EVENT_TYPE_CALL_RECONNECTING = "reconnecting";
  public static final String EVENT_TYPE_CALL_QUALITY = "qualityWarningsChanged";

  /**
   * Call keys.
   */
  public static final String EVENT_KEY_CALL_INFO = "call";
  public static final String EVENT_KEY_CALL_CUSTOM_PARAMETERS = "customParameters";
  public static final String EVENT_KEY_CALL_FROM = "from";
  public static final String EVENT_KEY_CALL_IS_MUTED = "isMuted";
  public static final String EVENT_KEY_CALL_IS_ON_HOLD = "isOnHold";
  public static final String EVENT_KEY_CALL_SID = "sid";
  public static final String EVENT_KEY_CALL_STATE = "state";
  public static final String EVENT_KEY_CALL_TO = "to";
  public static final String EVENT_KEY_CURRENT_CALL_QUALITY = "currentWarnings";
  public static final String EVENT_KEY_PREVIOUS_CALL_QUALITY = "previousWarnings";

  /**
   * CallInvite event keys.
   */
  public static final String EVENT_KEY_CALL_INVITE_INFO = "callInvite";
  public static final String EVENT_KEY_CALL_INVITE_CALL_SID = "callSid";
  public static final String EVENT_KEY_CALL_INVITE_CUSTOM_PARAMETERS = "customParameters";
  public static final String EVENT_KEY_CALL_INVITE_FROM = "from";
  public static final String EVENT_KEY_CALL_INVITE_TO = "to";

  /**
   * CancelledCallInvite event keys.
   */
  public static final String EVENT_KEY_CANCELLED_CALL_INVITE_INFO = "cancelledCallInvite";
  public static final String EVENT_KEY_CANCELLED_CALL_INVITE_CALL_SID = "callSid";
  public static final String EVENT_KEY_CANCELLED_CALL_INVITE_FROM = "from";
  public static final String EVENT_KEY_CANCELLED_CALL_INVITE_TO = "to";

  /**
   * Voice event types.
   */
  public static final String EVENT_TYPE_VOICE_CALL_INVITE = "callInvite";
  public static final String EVENT_TYPE_VOICE_CALL_INVITE_ACCEPTED = "callInviteAccepted";
  public static final String EVENT_TYPE_VOICE_CALL_INVITE_REJECTED = "callInviteRejected";
  public static final String EVENT_TYPE_VOICE_CANCELLED_CALL_INVITE = "cancelledCallInvite";
  public static final String EVENT_TYPE_VOICE_REGISTERED = "registered";
  public static final String EVENT_TYPE_VOICE_UNREGISTERED = "unregistered";
  public static final String EVENT_TYPE_VOICE_AUDIO_DEVICES_UPDATED = "audioDevicesUpdated";

  /**
   * AudioDevice event keys.
   */
  public static final String EVENT_KEY_AUDIO_DEVICES_NAME = "name";
  public static final String EVENT_KEY_AUDIO_DEVICES_TYPE = "type";
  public static final String EVENT_KEY_AUDIO_DEVICES_AUDIO_DEVICES = "audioDevices";
  public static final String EVENT_KEY_AUDIO_DEVICES_SELECTED_DEVICE = "selectedDevice";

  public static AndroidEventEmitter getInstance() {
    if (AndroidEventEmitter.instance == null) {
      instance = new AndroidEventEmitter();
    }

    return instance;
  }

  public void setContext(ReactApplicationContext context) {
    this.context = context;
  }

  public void sendEvent(String eventName, @Nullable WritableMap params) {
    if (BuildConfig.DEBUG) {
      Log.d(TAG, "sendEvent "+eventName+" params "+params);
    }

    if (context == null) {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "attempt to sendEvent without context");
      }
      return;
    }

    if (!context.hasActiveCatalystInstance()) {
      if (BuildConfig.DEBUG) {
        Log.d(TAG, "failed Catalyst instance not active");
      }
      return;
    }

    context
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit(eventName, params);
  }

}
