package com.tencent.p177mm.plugin.radar.p489ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.boy;
import com.tencent.p177mm.protocal.protobuf.bpb;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarUtils;", "", "()V", "getEncodeUsername", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getUsername", "lowerThanXHDPI", "", "context", "Landroid/content/Context;", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.g */
public final class C39561g {
    public static final C39561g pDK = new C39561g();

    static {
        AppMethodBeat.m2504i(103079);
        AppMethodBeat.m2505o(103079);
    }

    private C39561g() {
    }

    /* renamed from: b */
    public static String m67618b(bpb bpb) {
        AppMethodBeat.m2504i(103077);
        C25052j.m39376p(bpb, "member");
        String str = bpb.jBB;
        if (str == null) {
            str = bpb.wfK;
            if (str == null) {
                str = "";
            }
        }
        AppMethodBeat.m2505o(103077);
        return str;
    }

    /* renamed from: a */
    public static String m67617a(boy boy) {
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

    /* renamed from: c */
    public static String m67619c(bpb bpb) {
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

    /* renamed from: eJ */
    public static boolean m67620eJ(Context context) {
        AppMethodBeat.m2504i(103078);
        C25052j.m39376p(context, "context");
        Resources resources = context.getResources();
        C25052j.m39375o(resources, "context.resources");
        if (resources.getDisplayMetrics().densityDpi <= 240) {
            AppMethodBeat.m2505o(103078);
            return true;
        }
        AppMethodBeat.m2505o(103078);
        return false;
    }
}
