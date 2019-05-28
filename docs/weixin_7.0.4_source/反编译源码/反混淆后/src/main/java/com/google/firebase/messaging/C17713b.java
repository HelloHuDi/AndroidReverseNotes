package com.google.firebase.messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

/* renamed from: com.google.firebase.messaging.b */
public final class C17713b extends Exception {
    private final int errorCode;

    C17713b(String str) {
        int i = 1;
        super(str);
        AppMethodBeat.m2504i(77217);
        if (str != null) {
            String toLowerCase = str.toLowerCase(Locale.US);
            int i2 = -1;
            switch (toLowerCase.hashCode()) {
                case -1743242157:
                    if (toLowerCase.equals("service_not_available")) {
                        i2 = 3;
                        break;
                    }
                    break;
                case -1290953729:
                    if (toLowerCase.equals("toomanymessages")) {
                        i2 = 4;
                        break;
                    }
                    break;
                case -920906446:
                    if (toLowerCase.equals("invalid_parameters")) {
                        i2 = 0;
                        break;
                    }
                    break;
                case -617027085:
                    if (toLowerCase.equals("messagetoobig")) {
                        i2 = 2;
                        break;
                    }
                    break;
                case -95047692:
                    if (toLowerCase.equals("missing_to")) {
                        i2 = 1;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                case 1:
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 3;
                    break;
                case 4:
                    i = 4;
                    break;
            }
        }
        i = 0;
        this.errorCode = i;
        AppMethodBeat.m2505o(77217);
    }
}
