package com.tencent.p177mm.plugin.appbrand.media.p325a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C10304b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.media.a.a */
public final class C19600a {
    private static Map<String, C2389c> ikF = new ConcurrentHashMap();
    private static Map<String, C4884c> ikG = new HashMap();
    private static ArrayList<String> ikH = new ArrayList();
    private static Map<String, Boolean> ikI = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(137803);
        AppMethodBeat.m2505o(137803);
    }

    public static void onCreate(String str) {
        AppMethodBeat.m2504i(137795);
        C4990ab.m7416i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        ikF.clear();
        C10304b.onCreate(str);
        ikI.put(str, Boolean.TRUE);
        AppMethodBeat.m2505o(137795);
    }

    /* renamed from: AO */
    public static void m30383AO(String str) {
        AppMethodBeat.m2504i(137796);
        C4990ab.m7416i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
        C10304b.m17969AO(str);
        ikF.clear();
        Iterator it = ikH.iterator();
        while (it.hasNext()) {
            C4884c c4884c = (C4884c) ikG.remove((String) it.next());
            if (c4884c != null) {
                C4879a.xxA.mo10053d(c4884c);
            }
        }
        ikG.clear();
        ikH.clear();
        ikI.remove(str);
        AppMethodBeat.m2505o(137796);
    }

    /* renamed from: a */
    public static void m30387a(String str, C2389c c2389c) {
        AppMethodBeat.m2504i(137797);
        ikF.put(str, c2389c);
        AppMethodBeat.m2505o(137797);
    }

    /* renamed from: Cr */
    public static C2389c m30384Cr(String str) {
        AppMethodBeat.m2504i(137798);
        C2389c c2389c = (C2389c) ikF.get(str);
        AppMethodBeat.m2505o(137798);
        return c2389c;
    }

    /* renamed from: a */
    public static void m30388a(String str, C4884c c4884c) {
        AppMethodBeat.m2504i(137799);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
            AppMethodBeat.m2505o(137799);
        } else if (c4884c == null) {
            C4990ab.m7412e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
            AppMethodBeat.m2505o(137799);
        } else {
            if (ikG.containsKey(str)) {
                C19600a.m30385Cs(str);
            }
            C4990ab.m7411d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", str);
            ikG.put(str, c4884c);
            if (!ikH.contains(str)) {
                ikH.add(str);
            }
            C4879a.xxA.mo10051b(c4884c);
            AppMethodBeat.m2505o(137799);
        }
    }

    /* renamed from: Cs */
    public static void m30385Cs(String str) {
        AppMethodBeat.m2504i(137800);
        if (ikG.containsKey(str)) {
            C4990ab.m7411d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", str);
            ikH.remove(str);
            C4884c c4884c = (C4884c) ikG.remove(str);
            if (c4884c != null) {
                C4879a.xxA.mo10053d(c4884c);
            }
            AppMethodBeat.m2505o(137800);
            return;
        }
        C4990ab.m7413e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", str);
        AppMethodBeat.m2505o(137800);
    }

    /* renamed from: Ct */
    public static boolean m30386Ct(String str) {
        AppMethodBeat.m2504i(137801);
        if (ikI.containsKey(str)) {
            boolean booleanValue = ((Boolean) ikI.get(str)).booleanValue();
            AppMethodBeat.m2505o(137801);
            return booleanValue;
        }
        AppMethodBeat.m2505o(137801);
        return false;
    }

    /* renamed from: ao */
    public static void m30389ao(String str, boolean z) {
        AppMethodBeat.m2504i(137802);
        ikI.put(str, Boolean.valueOf(z));
        AppMethodBeat.m2505o(137802);
    }
}
