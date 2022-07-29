package com.qqlittleice.ironbridge.api.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.Keep;

import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

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
        public String getChannel() { return null; }
        @Override
        public IBinder asBinder() { return null; }
    }

    @Keep
    abstract class Stub extends Binder implements BridgeListener {

        private static final String DESCRIPTOR = "com.qqlittleice.ironbridge.aidl.BridgeListener";

        static final int TRANSACTION_getChannel = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_onReceivedString = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_onReceivedInt = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_onReceivedLong = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_onReceivedFloat = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_onReceivedDouble = IBinder.FIRST_CALL_TRANSACTION + 5;
        static final int TRANSACTION_onReceivedBoolean = IBinder.FIRST_CALL_TRANSACTION + 6;

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
                case TRANSACTION_getChannel: {
                    data.enforceInterface(descriptor);
                    String _result = getChannel();
                    reply.writeNoException();
                    reply.writeString(_result);
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
    String getChannel() throws RemoteException;
}
