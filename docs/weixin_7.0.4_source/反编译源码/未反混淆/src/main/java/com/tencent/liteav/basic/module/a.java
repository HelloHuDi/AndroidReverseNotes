package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private String mID = "";

    public void finalize() {
        AppMethodBeat.i(66076);
        clearID();
        super.finalize();
        AppMethodBeat.o(66076);
    }

    public void setID(String str) {
        AppMethodBeat.i(66077);
        clearID();
        synchronized (this) {
            try {
                if (str.length() != 0) {
                    this.mID = str;
                    TXCStatus.a(this.mID);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66077);
            }
        }
    }

    public void clearID() {
        AppMethodBeat.i(66078);
        synchronized (this) {
            try {
                if (this.mID.length() != 0) {
                    TXCStatus.b(this.mID);
                    this.mID = "";
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66078);
            }
        }
    }

    public String getID() {
        return this.mID;
    }

    public boolean setStatusValue(int i, Object obj) {
        AppMethodBeat.i(66079);
        boolean a = TXCStatus.a(this.mID, i, obj);
        AppMethodBeat.o(66079);
        return a;
    }

    public Object getStatusValue(int i) {
        AppMethodBeat.i(66080);
        Object a = TXCStatus.a(this.mID, i);
        AppMethodBeat.o(66080);
        return a;
    }
}
