package com.qqlittleice.ironbridge.api.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.Keep;

import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

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
        public IBinder asBinder() { return null; }
    }

    @Keep
    abstract class Stub extends Binder implements Ironbridge {

        public static final String DESCRIPTOR = "com.qqlittleice.ironbridge.aidl.Ironbridge";

        static final int TRANSACTION_addListener = IBinder.FIRST_CALL_TRANSACTION;
        static final int TRANSACTION_removeListener = IBinder.FIRST_CALL_TRANSACTION + 1;
        static final int TRANSACTION_sendString = IBinder.FIRST_CALL_TRANSACTION + 2;
        static final int TRANSACTION_sendInt = IBinder.FIRST_CALL_TRANSACTION + 3;
        static final int TRANSACTION_sendLong = IBinder.FIRST_CALL_TRANSACTION + 4;
        static final int TRANSACTION_sendFloat = IBinder.FIRST_CALL_TRANSACTION + 5;
        static final int TRANSACTION_sendDouble = IBinder.FIRST_CALL_TRANSACTION + 6;
        static final int TRANSACTION_sendBoolean = IBinder.FIRST_CALL_TRANSACTION + 7;

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

            @Override
            public void addListener(BridgeListener listener) throws RemoteException {
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

}
