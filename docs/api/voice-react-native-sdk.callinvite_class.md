<!-- Do not edit this file. It is automatically generated by API Documenter. -->

[Home](./index.md) &gt; [@twilio/voice-react-native-sdk](./voice-react-native-sdk.md) &gt; [CallInvite](./voice-react-native-sdk.callinvite_class.md)

## CallInvite class

Provides access to information about a call invite, including the call parameters, and exposes functionality to accept or decline a call.

<b>Signature:</b>

```typescript
export declare class CallInvite extends EventEmitter 
```
<b>Extends:</b> EventEmitter

## Remarks

Note that when a `CallInvite` is acted upon (i.e. when [CallInvite.accept()](./voice-react-native-sdk.callinvite_class.accept_method.md) or [CallInvite.reject()](./voice-react-native-sdk.callinvite_class.reject_method.md) is invoked), then the `CallInvite` is "settled".

The state of the `CallInvite` is changed from [CallInvite.State.Pending](./voice-react-native-sdk.callinvite_namespace.state_enum.md) to [CallInvite.State.Accepted](./voice-react-native-sdk.callinvite_namespace.state_enum.md) or [CallInvite.State.Rejected](./voice-react-native-sdk.callinvite_namespace.state_enum.md) and the `CallInvite` can no longer be acted upon further.

Further action after "settling" a `CallInvite` will throw an error.

- See the [CallInvite namespace](./voice-react-native-sdk.callinvite_namespace.md) for enumerations and types used by this class.

The constructor for this class is marked as internal. Third-party code should not call the constructor directly or create subclasses that extend the `CallInvite` class.

## Methods

|  Method | Modifiers | Description |
|  --- | --- | --- |
|  [accept(options)](./voice-react-native-sdk.callinvite_class.accept_method.md) |  | Accept a call invite. Sets the state of this call invite to [CallInvite.State.Accepted](./voice-react-native-sdk.callinvite_namespace.state_enum.md)<!-- -->. |
|  [getCallSid()](./voice-react-native-sdk.callinvite_class.getcallsid_method.md) |  | Get the call SID associated with this <code>CallInvite</code> class. |
|  [getCustomParameters()](./voice-react-native-sdk.callinvite_class.getcustomparameters_method.md) |  | Get the custom parameters of the call associated with this <code>CallInvite</code> class. |
|  [getFrom()](./voice-react-native-sdk.callinvite_class.getfrom_method.md) |  | Get the <code>from</code> parameter of the call associated with this <code>CallInvite</code> class. |
|  [getState()](./voice-react-native-sdk.callinvite_class.getstate_method.md) |  | Get the <code>state</code> of the <code>CallInvite</code>. |
|  [getTo()](./voice-react-native-sdk.callinvite_class.getto_method.md) |  | Get the <code>to</code> parameter of the call associated with this <code>CallInvite</code> class. |
|  [reject()](./voice-react-native-sdk.callinvite_class.reject_method.md) |  | Reject a call invite. Sets the state of this call invite to [CallInvite.State.Rejected](./voice-react-native-sdk.callinvite_namespace.state_enum.md)<!-- -->. |
|  [sendMessage(message)](./voice-react-native-sdk.callinvite_class.sendmessage_method.md) |  | Send [CallMessage](./voice-react-native-sdk.callmessage_class.md)<!-- -->. |
|  [updateCallerHandle(newHandle)](./voice-react-native-sdk.callinvite_class.updatecallerhandle_method.md) |  | Update the caller name displayed in the iOS system incoming call screen. |
