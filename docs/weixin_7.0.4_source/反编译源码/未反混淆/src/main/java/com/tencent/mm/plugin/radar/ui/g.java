package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.bpb;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
public final class g {
    public static final g pDK = new g();

    static {
        AppMethodBeat.i(103079);
        AppMethodBeat.o(103079);
    }

    private g() {
    }

    public static String b(bpb bpb) {
        AppMethodBeat.i(103077);
        j.p(bpb, "member");
        String str = bpb.jBB;
        if (str == null) {
            str = bpb.wfK;
            if (str == null) {
                str = "";
            }
        }
        AppMethodBeat.o(103077);
        return str;
    }

    public static String a(boy boy) {
        if (boy != null) {
            String str = boy.wfK;
            if (str == null) {
                str = boy.jBB;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static String c(bpb bpb) {
        if (bpb != null) {
            String str = bpb.wfK;
            if (str == null) {
                str = bpb.jBB;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static boolean eJ(Context context) {
        AppMethodBeat.i(103078);
        j.p(context, "context");
        Resources resources = context.getResources();
        j.o(resources, "context.resources");
        if (resources.getDisplayMetrics().densityDpi <= 240) {
            AppMethodBeat.o(103078);
            return true;
        }
        AppMethodBeat.o(103078);
        return false;
    }
}
