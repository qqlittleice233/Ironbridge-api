package com.qqlittleice.ironbridge.api;

import android.annotation.SuppressLint;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

import androidx.annotation.Nullable;

import com.qqlittleice.ironbridge.api.aidl.Ironbridge;
import com.qqlittleice.ironbridge.api.annotation.BridgeVersion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class IronBridge {

    private static final String TAG = "XServiceManager";

    /**
     * Get the bridge by given name.
     * <p>
     * @param name The name of the bridge.
     * <p>
     * @return {@link Ironbridge}
     */
    @BridgeVersion(1)
    @Nullable
    public static Ironbridge getBridge(String name) {
        String realName = "Ib_" + name;
        try {
            @SuppressLint("PrivateApi") Class<?> ServiceManagerClass = Class.forName("android.os.ServiceManager");
            Method checkService = ServiceManagerClass.getMethod("checkService", String.class);
            IBinder delegateService = (IBinder)checkService.invoke(null, "clipboard");
            Objects.requireNonNull(delegateService, "can't not access delegate service");
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();
            try {
                _data.writeInterfaceToken("com.kaisar.xservicemanager.XServiceManager");
                _data.writeString(realName);
                delegateService.transact(IBinder.LAST_CALL_TRANSACTION, _data, _reply, 0);
                _reply.readException();
                IBinder binder = _reply.readStrongBinder();
                if (binder.getInterfaceDescriptor().equals(Ironbridge.Stub.DESCRIPTOR)) {
                    return Ironbridge.Stub.asInterface(binder);
                } else {
                    throw new IllegalArgumentException("not a Ironbridge");
                }
            } finally {
                _data.recycle();
                _reply.recycle();
            }
        } catch(Exception e) {
            Log.e(TAG, String.format("get %s service error", realName), e instanceof InvocationTargetException ? e.getCause() : e);
            return null;
        }
    }

    /**
     * Get the public bridge.
     * <p>
     * @return {@link Ironbridge}
     */
    @BridgeVersion(1)
    @Nullable
    public static Ironbridge getPublicBridge() {
        return getBridge("public");
    }

}
