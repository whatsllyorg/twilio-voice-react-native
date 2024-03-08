<!-- Do not edit this file. It is automatically generated by API Documenter. -->

[Home](./index.md) &gt; [@twilio/voice-react-native-sdk](./voice-react-native-sdk.md) &gt; [Call](./voice-react-native-sdk.call_interface.md) &gt; [on](./voice-react-native-sdk.call_interface.on_3_methodsignature.md)

## Call.on() method

Reconnected event. Raised when the call has recovered and reconnected.

<b>Signature:</b>

```typescript
on(reconnectedEvent: Call.Event.Reconnected, listener: Call.Listener.Reconnected): this;
```

## Parameters

|  Parameter | Type | Description |
|  --- | --- | --- |
|  reconnectedEvent | [Call.Event.Reconnected](./voice-react-native-sdk.call_namespace.event_enum.md) | The raised event string. |
|  listener | [Call.Listener.Reconnected](./voice-react-native-sdk.call_namespace.listener_namespace.reconnected_typealias.md) | A listener function that will be invoked when the event is raised. |

<b>Returns:</b>

this

- The call object.
