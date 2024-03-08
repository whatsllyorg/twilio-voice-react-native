<!-- Do not edit this file. It is automatically generated by API Documenter. -->

[Home](./index.md) &gt; [@twilio/voice-react-native-sdk](./voice-react-native-sdk.md) &gt; [CallInvite](./voice-react-native-sdk.callinvite_interface.md) &gt; [on](./voice-react-native-sdk.callinvite_interface.on_4_methodsignature.md)

## CallInvite.on() method

MessageReceived event. Raised when [CallMessage](./voice-react-native-sdk.callmessage_class.md) is received.

<b>Signature:</b>

```typescript
on(messageReceivedEvent: CallInvite.Event.MessageReceived, listener: CallInvite.Listener.MessageReceived): this;
```

## Parameters

|  Parameter | Type | Description |
|  --- | --- | --- |
|  messageReceivedEvent | [CallInvite.Event.MessageReceived](./voice-react-native-sdk.callinvite_namespace.event_enum.md) | The raised event string. |
|  listener | [CallInvite.Listener.MessageReceived](./voice-react-native-sdk.callinvite_namespace.listener_namespace.messagereceived_typealias.md) | A listener function that will be invoked when the event is raised. |

<b>Returns:</b>

this

- The callMessage object
