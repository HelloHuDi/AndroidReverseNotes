package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.basic.module.a */
public class C32147a {
    private String mID = "";

    public void finalize() {
        AppMethodBeat.m2504i(66076);
        clearID();
        super.finalize();
        AppMethodBeat.m2505o(66076);
    }

    public void setID(String str) {
        AppMethodBeat.m2504i(66077);
        clearID();
        synchronized (this) {
            try {
                if (str.length() != 0) {
                    this.mID = str;
                    TXCStatus.m40651a(this.mID);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66077);
            }
        }
    }

    public void clearID() {
        AppMethodBeat.m2504i(66078);
        synchronized (this) {
            try {
                if (this.mID.length() != 0) {
                    TXCStatus.m40654b(this.mID);
                    this.mID = "";
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66078);
            }
        }
    }

    public String getID() {
        return this.mID;
    }

    public boolean setStatusValue(int i, Object obj) {
        AppMethodBeat.m2504i(66079);
        boolean a = TXCStatus.m40652a(this.mID, i, obj);
        AppMethodBeat.m2505o(66079);
        return a;
    }

    public Object getStatusValue(int i) {
        AppMethodBeat.m2504i(66080);
        Object a = TXCStatus.m40650a(this.mID, i);
        AppMethodBeat.m2505o(66080);
        return a;
    }
}
