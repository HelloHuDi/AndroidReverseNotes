package com.tencent.p659pb.common.p660b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;

/* renamed from: com.tencent.pb.common.b.g */
public final class C44440g {
    private WifiInfo Amk = null;
    private int Aml = 1;
    private NetworkInfo ebY = null;

    /* renamed from: Il */
    public final synchronized boolean mo70374Il() {
        boolean z;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) C46729d.sZj.getSystemService("connectivity");
                if (connectivityManager == null) {
                    C44443c.m80392w("NetworkChangeMgr", "can't get ConnectivityManager");
                    this.Aml = 1;
                    this.Amk = null;
                    this.ebY = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.Aml = 1;
                        this.Amk = null;
                        this.ebY = null;
                        z = true;
                    } else {
                        int i;
                        C44443c.m80389d("NetworkChangeMgr", "NetworkChangeMgr ", activeNetworkInfo);
                        if (!activeNetworkInfo.isConnected()) {
                            i = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            i = 2;
                            wifiInfo = ((WifiManager) C46729d.sZj.getSystemService("wifi")).getConnectionInfo();
                        } else {
                            i = 3;
                        }
                        if (i == this.Aml) {
                            if (i == 1) {
                                z = false;
                            } else if (i == 2) {
                                if (wifiInfo != null && this.Amk != null && this.Amk.getBSSID().equals(wifiInfo.getBSSID()) && this.Amk.getSSID().equals(wifiInfo.getSSID()) && this.Amk.getNetworkId() == wifiInfo.getNetworkId()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (this.ebY != null && this.ebY.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.ebY.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.ebY.getSubtype() == activeNetworkInfo.getSubtype() && this.ebY.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.ebY != null && this.ebY.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.ebY.getSubtype() == activeNetworkInfo.getSubtype() && this.ebY.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.Aml = i;
                            this.Amk = wifiInfo;
                            this.ebY = activeNetworkInfo;
                        }
                        z = true;
                        this.Aml = i;
                        this.Amk = wifiInfo;
                        this.ebY = activeNetworkInfo;
                    }
                }
            } catch (Exception e) {
                C44443c.m80392w("NetworkChangeMgr", e);
                this.Aml = 1;
                this.Amk = null;
                this.ebY = null;
                z = true;
            }
        }
        return z;
    }
}
