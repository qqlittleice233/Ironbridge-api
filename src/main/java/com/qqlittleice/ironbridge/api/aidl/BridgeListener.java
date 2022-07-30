package com.qqlittleice.ironbridge.api.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

import androidx.annotation.Keep;

import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A listener for {@link Ironbridge}.
 * <p>
 * This listener is used to receive the content sent by other client.
 * */
@Keep
public interface BridgeListener extends IInterface {

    @Keep
    class Default implements BridgeListener {
        @Override
        public void onReceivedString(String key, String value) {}
        @Override
        public void onReceivedInt(String key, int value) {}
        @Override
        public void onReceivedLong(String key, long value) {}
        @Override
        public void onReceivedFloat(String key, float value) {}
        @Override
        public void onReceivedDouble(String key, double value) {}
        @Override
        public void onReceivedBoolean(String key, boolean value) {}
        @Override
        public void onReceivedStringList(String key, List<String> value) {}
        @Override
        public void onReceivedIntList(String key, List<Integer> value) {}
        @Override
        public void onReceivedLongList(String key, List<Long> value) {}
        @Override
        public void onReceivedFloatList(String key, List<Float> value) {}
        @Override
        public void onReceivedDoubleList(String key, List<Double> value) {}
        @Override
        public void onReceivedBooleanList(String key, List<Boolean> value) {}
        @Override
        public void onReceivedParcelable(String key, Parcelable value) {}
        @Override
        public void onReceivedSerializable(String key, Serializable value) {}
        @Override
        public void onReceivedIBinder(String key, IBinder value) {}

        @Override
        public String getChannel() { return null; }
        @Override
        public IBinder asBinder() { return null; }
    }

    @Keep
    abstract class Stub extends Binder implements BridgeListener {

        public static final String DESCRIPTOR = "com.qqlittleice.ironbridge.aidl.BridgeListener";
        public static final int api = 1;

        static final int TRANSACTION_getChannel = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_onReceivedString = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_onReceivedInt = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_onReceivedLong = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_onReceivedFloat = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_onReceivedDouble = IBinder.FIRST_CALL_TRANSACTION + 5;
        static final int TRANSACTION_onReceivedBoolean = IBinder.FIRST_CALL_TRANSACTION + 6;
        static final int TRANSACTION_onReceivedStringList = IBinder.FIRST_CALL_TRANSACTION + 7;
        static final int TRANSACTION_onReceivedIntList = IBinder.FIRST_CALL_TRANSACTION + 8;
        static final int TRANSACTION_onReceivedLongList = IBinder.FIRST_CALL_TRANSACTION + 9;
        static final int TRANSACTION_onReceivedFloatList = IBinder.FIRST_CALL_TRANSACTION + 10;
        static final int TRANSACTION_onReceivedDoubleList = IBinder.FIRST_CALL_TRANSACTION + 11;
        static final int TRANSACTION_onReceivedBooleanList = IBinder.FIRST_CALL_TRANSACTION + 12;
        static final int TRANSACTION_onReceivedParcelable = IBinder.FIRST_CALL_TRANSACTION + 13;
        static final int TRANSACTION_onReceivedSerializable = IBinder.FIRST_CALL_TRANSACTION + 14;
        static final int TRANSACTION_onReceivedIBinder = IBinder.FIRST_CALL_TRANSACTION + 15;
        public static final int TRANSACTION_API = IBinder.LAST_CALL_TRANSACTION;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static BridgeListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(DESCRIPTOR);
            if (localInterface instanceof BridgeListener) {
                return (BridgeListener)localInterface;
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
                case TRANSACTION_onReceivedString: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    String value = data.readString();
                    onReceivedString(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedInt: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    int value = data.readInt();
                    onReceivedInt(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedLong: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    long value = data.readLong();
                    onReceivedLong(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedFloat: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    float value = data.readFloat();
                    onReceivedFloat(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedDouble: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    double value = data.readDouble();
                    onReceivedDouble(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedBoolean: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    boolean value = data.readInt() != 0;
                    onReceivedBoolean(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedStringList: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    List<String> value = data.createStringArrayList();
                    onReceivedStringList(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedIntList: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    List<Integer> value = Arrays.stream(data.createIntArray()).boxed().collect(Collectors.toList());
                    onReceivedIntList(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedLongList: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    List<Long> value = Arrays.stream(data.createLongArray()).boxed().collect(Collectors.toList());
                    onReceivedLongList(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedFloatList: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    float[] array = data.createFloatArray();
                    List<Float> list = new ArrayList<>(array.length);
                    for (float f : array) {
                        list.add(f);
                    }
                    onReceivedFloatList(key, list);
                    return true;
                }
                case TRANSACTION_onReceivedDoubleList: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    List<Double> value = Arrays.stream(data.createDoubleArray()).boxed().collect(Collectors.toList());
                    onReceivedDoubleList(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedBooleanList: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    boolean[] array = data.createBooleanArray();
                    List<Boolean> list = new ArrayList<>(array.length);
                    for (boolean b : array) {
                        list.add(b);
                    }
                    onReceivedBooleanList(key, list);
                    return true;
                }
                case TRANSACTION_onReceivedParcelable: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    Parcelable value = data.readParcelable(getClass().getClassLoader());
                    onReceivedParcelable(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedSerializable: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    Serializable value = data.readSerializable();
                    onReceivedSerializable(key, value);
                    return true;
                }
                case TRANSACTION_onReceivedIBinder: {
                    data.enforceInterface(descriptor);
                    String key = data.readString();
                    IBinder value = data.readStrongBinder();
                    onReceivedIBinder(key, value);
                    return true;
                }
                case TRANSACTION_getChannel: {
                    data.enforceInterface(descriptor);
                    String _result = getChannel();
                    reply.writeNoException();
                    reply.writeString(_result);
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

        public static boolean setDefaultImpl(BridgeListener impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }

        public static BridgeListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override
        public void onReceivedString(String key, String value) {}
        @Override
        public void onReceivedInt(String key, int value) {}
        @Override
        public void onReceivedLong(String key, long value) {}
        @Override
        public void onReceivedFloat(String key, float value) {}
        @Override
        public void onReceivedDouble(String key, double value) {}
        @Override
        public void onReceivedBoolean(String key, boolean value) {}
        @Override
        public void onReceivedStringList(String key, List<String> value) {}
        @Override
        public void onReceivedIntList(String key, List<Integer> value) {}
        @Override
        public void onReceivedLongList(String key, List<Long> value) {}
        @Override
        public void onReceivedFloatList(String key, List<Float> value) {}
        @Override
        public void onReceivedDoubleList(String key, List<Double> value) {}
        @Override
        public void onReceivedBooleanList(String key, List<Boolean> value) {}
        @Override
        public void onReceivedParcelable(String key, Parcelable value) {}
        @Override
        public void onReceivedSerializable(String key, Serializable value) {}
        @Override
        public void onReceivedIBinder(String key, IBinder value) {}

        @Keep
        private static class Proxy implements BridgeListener {

            private final IBinder mRemote;
            public static BridgeListener sDefaultImpl;

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

            @Override
            public void onReceivedString(String key, String value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeString(value);
                    boolean _status = mRemote.transact(TRANSACTION_onReceivedString, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedString(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedInt(String key, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeInt(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedInt, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedInt(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedLong(String key, long value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeLong(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedLong, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedLong(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedFloat(String key, float value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeFloat(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedFloat, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedFloat(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedDouble(String key, double value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeDouble(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedDouble, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedDouble(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedBoolean(String key, boolean value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeInt(value ? 1 : 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedBoolean, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedBoolean(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedStringList(String key, List<String> value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeStringList(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedStringList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedStringList(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedIntList(String key, List<Integer> value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeIntArray(value.stream().mapToInt(Integer::intValue).toArray());
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedIntList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedIntList(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedLongList(String key, List<Long> value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeLongArray(value.stream().mapToLong(Long::longValue).toArray());
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedLongList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedLongList(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedFloatList(String key, List<Float> value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    float[] array = new float[value.size()];
                    for (int i = 0; i < value.size(); i++) {
                        array[i] = value.get(i);
                    }
                    _data.writeFloatArray(array);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedFloatList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedFloatList(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedDoubleList(String key, List<Double> value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeDoubleArray(value.stream().mapToDouble(Double::doubleValue).toArray());
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedDoubleList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedDoubleList(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedBooleanList(String key, List<Boolean> value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    boolean[] array = new boolean[value.size()];
                    for (int i = 0; i < value.size(); i++) {
                        array[i] = value.get(i);
                    }
                    _data.writeBooleanArray(array);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedBooleanList, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedBooleanList(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedParcelable(String key, Parcelable value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeParcelable(value, 0);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedParcelable, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedParcelable(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedSerializable(String key, Serializable value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeSerializable(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedSerializable, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedSerializable(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onReceivedIBinder(String key, IBinder value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(key);
                    _data.writeStrongBinder(value);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_onReceivedIBinder, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onReceivedIBinder(key, value);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public String getChannel() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                String _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(Stub.TRANSACTION_getChannel, _data, _reply, 0);
                    if (!_status && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getChannel();
                    }
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }
    }

    @BridgeVersion(1)
    void onReceivedString(String key, String value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedInt(String key, int value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedLong(String key, long value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedFloat(String key, float value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedDouble(String key, double value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedBoolean(String key, boolean value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedStringList(String key, List<String> value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedIntList(String key, List<Integer> value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedLongList(String key, List<Long> value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedFloatList(String key, List<Float> value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedDoubleList(String key, List<Double> value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedBooleanList(String key, List<Boolean> value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedParcelable(String key, Parcelable value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedSerializable(String key, Serializable value) throws RemoteException;

    @BridgeVersion(1)
    void onReceivedIBinder(String key, IBinder value) throws RemoteException;

    @BridgeVersion(1)
    String getChannel() throws RemoteException;
}
