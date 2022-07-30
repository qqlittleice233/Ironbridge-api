package com.qqlittleice.ironbridge.api.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Keep;

import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The bridge for sending and receiving data.
 * */
@Keep
public interface Ironbridge extends IInterface {

    @Keep
    class Default implements Ironbridge {
        @Override
        public void addListener(BridgeListener listener) {}
        @Override
        public void removeListener(BridgeListener listener) {}
        @Override
        public void sendString(String channel, String key, String value) {}
        @Override
        public void sendInt(String channel, String key, int value) {}
        @Override
        public void sendLong(String channel, String key, long value) {}
        @Override
        public void sendFloat(String channel, String key, float value) {}
        @Override
        public void sendDouble(String channel, String key, double value) {}
        @Override
        public void sendBoolean(String channel, String key, boolean value) {}
        @Override
        public void sendStringList(String channel, String key, List<String> value) {}
        @Override
        public void sendIntList(String channel, String key, List<Integer> value) {}
        @Override
        public void sendLongList(String channel, String key, List<Long> value) {}
        @Override
        public void sendFloatList(String channel, String key, List<Float> value) {}
        @Override
        public void sendDoubleList(String channel, String key, List<Double> value) {}
        @Override
        public void sendBooleanList(String channel, String key, List<Boolean> value) {}
        @Override
        public void sendParcelable(String channel, String key, Parcelable value) {}
        @Override
        public void sendSerializable(String channel, String key, Serializable value) {}

        @Override
        public IBinder asBinder() { return null; }
    }

    @Keep
    abstract class Stub extends Binder implements Ironbridge {

        public static final String DESCRIPTOR = "com.qqlittleice.ironbridge.aidl.Ironbridge";
        public static final int api = 1;

        static final int TRANSACTION_addListener = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_removeListener = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_sendString = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_sendInt = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_sendLong = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_sendFloat = IBinder.FIRST_CALL_TRANSACTION + 5;
        static final int TRANSACTION_sendDouble = IBinder.FIRST_CALL_TRANSACTION + 6;
        static final int TRANSACTION_sendBoolean = IBinder.FIRST_CALL_TRANSACTION + 7;
        static final int TRANSACTION_sendStringList = IBinder.FIRST_CALL_TRANSACTION + 8;
        static final int TRANSACTION_sendIntList = IBinder.FIRST_CALL_TRANSACTION + 9;
        static final int TRANSACTION_sendLongList = IBinder.FIRST_CALL_TRANSACTION + 10;
        static final int TRANSACTION_sendFloatList = IBinder.FIRST_CALL_TRANSACTION + 11;
        static final int TRANSACTION_sendDoubleList = IBinder.FIRST_CALL_TRANSACTION + 12;
        static final int TRANSACTION_sendBooleanList = IBinder.FIRST_CALL_TRANSACTION + 13;
        static final int TRANSACTION_sendParcelable = IBinder.FIRST_CALL_TRANSACTION + 14;
        static final int TRANSACTION_sendSerializable = IBinder.FIRST_CALL_TRANSACTION + 15;
        static final int TRANSACTION_API = IBinder.LAST_CALL_TRANSACTION;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static Ironbridge asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(DESCRIPTOR);
            if ((localInterface instanceof Ironbridge)) {
                return (Ironbridge) localInterface;
            }
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            String descriptor = DESCRIPTOR;
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_addListener: {
                    data.enforceInterface(descriptor);
                    BridgeListener listener = BridgeListener.Stub.asInterface(data.readStrongBinder());
                    this.addListener(listener);
                    return true;
                }
                case TRANSACTION_removeListener: {
                    data.enforceInterface(descriptor);
                    BridgeListener listener = BridgeListener.Stub.asInterface(data.readStrongBinder());
                    this.removeListener(listener);
                    return true;
                }
                case TRANSACTION_sendString: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    String value = data.readString();
                    sendString(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendInt: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    int value = data.readInt();
                    sendInt(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendLong: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    long value = data.readLong();
                    sendLong(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendFloat: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    float value = data.readFloat();
                    sendFloat(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendDouble: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    double value = data.readDouble();
                    sendDouble(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendBoolean: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    boolean value = data.readInt() != 0;
                    sendBoolean(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendStringList: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    List<String> value = data.createStringArrayList();
                    sendStringList(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendIntList: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    List<Integer> value = Arrays.stream(data.createIntArray()).boxed().collect(Collectors.toList());
                    sendIntList(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendLongList: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    List<Long> value = Arrays.stream(data.createLongArray()).boxed().collect(Collectors.toList());
                    sendLongList(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendFloatList: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    float[] array = data.createFloatArray();
                    List<Float> list = new ArrayList<>(array.length);
                    for (float f : array) {
                        list.add(f);
                    }
                    sendFloatList(channel, key, list);
                    return true;
                }
                case TRANSACTION_sendDoubleList: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    List<Double> value = Arrays.stream(data.createDoubleArray()).boxed().collect(Collectors.toList());
                    sendDoubleList(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendBooleanList: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    boolean[] array = data.createBooleanArray();
                    List<Boolean> list = new ArrayList<>(array.length);
                    for (boolean b : array) {
                        list.add(b);
                    }
                    sendBooleanList(channel, key, list);
                    return true;
                }
                case TRANSACTION_sendParcelable: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    Parcelable value = data.readParcelable(getClass().getClassLoader());
                    sendParcelable(channel, key, value);
                    return true;
                }
                case TRANSACTION_sendSerializable: {
                    data.enforceInterface(descriptor);
                    String channel = data.readString();
                    String key = data.readString();
                    Serializable value = data.readSerializable();
                    sendSerializable(channel, key, value);
                    return true;
                }
                case TRANSACTION_API: {
                    data.enforceInterface(descriptor);
                    reply.writeNoException();
                    reply.writeInt(api);
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(Ironbridge impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static Ironbridge getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Keep
        private static class Proxy implements Ironbridge {

            private final IBinder mRemote;
            public static Ironbridge sDefaultImpl;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            public int getRemoteApiVersion() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(TRANSACTION_API, _data, _reply, 0);
                    if (!_status) {
                        Log.d("IronBridge", "get remote api version failed");
                        return 0;
                    }
                    _reply.readException();
                    return _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean checkApiVersion(int requireApi) throws RemoteException {
                int remoteApi = getRemoteApiVersion();
                return remoteApi >= requireApi;
            }

            @Override
            public void addListener(BridgeListener listener) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_addListener, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().addListener(listener);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void removeListener(BridgeListener listener) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_removeListener, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().removeListener(listener);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendString(String channel, String key, String value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeString(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendString, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendString(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendInt(String channel, String key, int value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeInt(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendInt, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendInt(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendLong(String channel, String key, long value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeLong(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendLong, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendLong(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendFloat(String channel, String key, float value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeFloat(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendFloat, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendFloat(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendDouble(String channel, String key, double value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeDouble(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendDouble, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendDouble(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendBoolean(String channel, String key, boolean value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendBoolean, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendBoolean(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendStringList(String channel, String key, List<String> value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeStringList(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendStringList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendStringList(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendIntList(String channel, String key, List<Integer> value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeIntArray(value.stream().mapToInt(Integer::intValue).toArray());
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendIntList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendIntList(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendLongList(String channel, String key, List<Long> value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeLongArray(value.stream().mapToLong(Long::longValue).toArray());
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendLongList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendLongList(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendFloatList(String channel, String key, List<Float> value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    float[] array = new float[value.size()];
                    for (int i = 0; i < value.size(); i++) {
                        array[i] = value.get(i);
                    }
                    _data.writeFloatArray(array);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendFloatList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendFloatList(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendDoubleList(String channel, String key, List<Double> value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeDoubleArray(value.stream().mapToDouble(Double::doubleValue).toArray());
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendDoubleList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendDoubleList(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendBooleanList(String channel, String key, List<Boolean> value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    boolean[] array = new boolean[value.size()];
                    for (int i = 0; i < value.size(); i++) {
                        array[i] = value.get(i);
                    }
                    _data.writeBooleanArray(array);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendBooleanList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendBooleanList(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendParcelable(String channel, String key, Parcelable value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeParcelable(value, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendParcelable, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendParcelable(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void sendSerializable(String channel, String key, Serializable value) throws RemoteException {
                if (!checkApiVersion(1)) {
                    Log.d("IronBridge", "remote api version is too low, require 1");
                    return;
                }
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(channel);
                    _data.writeString(key);
                    _data.writeSerializable(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_sendSerializable, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendSerializable(channel, key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }
        }
    }

    @BridgeVersion(1)
    void addListener(BridgeListener listener) throws RemoteException;

    @BridgeVersion(1)
    void removeListener(BridgeListener listener) throws RemoteException;

    @BridgeVersion(1)
    void sendString(String channel, String key, String value) throws RemoteException;

    @BridgeVersion(1)
    void sendInt(String channel, String key, int value) throws RemoteException;

    @BridgeVersion(1)
    void sendLong(String channel, String key, long value) throws RemoteException;

    @BridgeVersion(1)
    void sendFloat(String channel, String key, float value) throws RemoteException;

    @BridgeVersion(1)
    void sendDouble(String channel, String key, double value) throws RemoteException;

    @BridgeVersion(1)
    void sendBoolean(String channel, String key, boolean value) throws RemoteException;

    @BridgeVersion(1)
    void sendStringList(String channel, String key, List<String> value) throws RemoteException;

    @BridgeVersion(1)
    void sendIntList(String channel, String key, List<Integer> value) throws RemoteException;

    @BridgeVersion(1)
    void sendLongList(String channel, String key, List<Long> value) throws RemoteException;

    @BridgeVersion(1)
    void sendFloatList(String channel, String key, List<Float> value) throws RemoteException;

    @BridgeVersion(1)
    void sendDoubleList(String channel, String key, List<Double> value) throws RemoteException;

    @BridgeVersion(1)
    void sendBooleanList(String channel, String key, List<Boolean> value) throws RemoteException;

    @BridgeVersion(1)
    void sendParcelable(String channel, String key, Parcelable value) throws RemoteException;

    @BridgeVersion(1)
    void sendSerializable(String channel, String key, Serializable value) throws RemoteException;

}
