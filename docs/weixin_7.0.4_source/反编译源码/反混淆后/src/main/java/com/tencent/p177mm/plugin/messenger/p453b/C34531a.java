package com.tencent.p177mm.plugin.messenger.p453b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p190at.p191a.p1527d.C45159a;
import com.tencent.p177mm.p612ui.base.p1421a.C30375a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.p453b.C3451b.C3452a;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12515c;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12516a;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12517b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.messenger.b.a */
public final class C34531a implements C12514e {
    private Map<String, LinkedList<C12517b>> oqU = new HashMap();
    private Map<String, LinkedList<C12516a>> oqV = new HashMap();
    private Map<String, HashSet<C12515c>> oqW = new HashMap();
    private C45159a<Long, CharSequence> oqX = new C45159a(200);
    private C45159a<Long, CharSequence> oqY = new C45159a(500);
    public C3473o oqZ = new C345321();

    /* renamed from: com.tencent.mm.plugin.messenger.b.a$1 */
    class C345321 implements C3473o {
        C345321() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(136919);
            C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", map.toString());
            C34531a.m56611a(C34531a.this, str, (Map) map, c1197a);
            AppMethodBeat.m2505o(136919);
        }
    }

    public C34531a() {
        AppMethodBeat.m2504i(136923);
        AppMethodBeat.m2505o(136923);
    }

    /* renamed from: a */
    public final void mo24440a(final String str, final C12515c c12515c) {
        AppMethodBeat.m2504i(136924);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(136920);
                C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", str);
                HashSet hashSet = (HashSet) C34531a.this.oqW.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                if (!hashSet.contains(c12515c)) {
                    hashSet.add(c12515c);
                }
                C34531a.this.oqW.put(str, hashSet);
                AppMethodBeat.m2505o(136920);
            }
        });
        AppMethodBeat.m2505o(136924);
    }

    /* renamed from: b */
    public final void mo24441b(final String str, final C12515c c12515c) {
        AppMethodBeat.m2504i(136925);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(136921);
                C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", str);
                HashSet hashSet = (HashSet) C34531a.this.oqW.get(str);
                if (hashSet == null) {
                    AppMethodBeat.m2505o(136921);
                    return;
                }
                hashSet.remove(c12515c);
                if (hashSet.size() == 0) {
                    C34531a.this.oqW.remove(str);
                    AppMethodBeat.m2505o(136921);
                    return;
                }
                C34531a.this.oqW.put(str, hashSet);
                AppMethodBeat.m2505o(136921);
            }
        });
        AppMethodBeat.m2505o(136925);
    }

    /* renamed from: a */
    public final void mo24439a(String str, C12517b c12517b) {
        AppMethodBeat.m2504i(136926);
        C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", str);
        if (!this.oqU.containsKey(str)) {
            this.oqU.put(str, new LinkedList());
        }
        if (!((List) this.oqU.get(str)).contains(c12517b)) {
            ((LinkedList) this.oqU.get(str)).add(c12517b);
        }
        AppMethodBeat.m2505o(136926);
    }

    /* renamed from: QB */
    public final void mo24434QB(String str) {
        AppMethodBeat.m2504i(136927);
        C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", str);
        if (!this.oqU.containsKey(str)) {
            C4990ab.m7421w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", str);
        }
        LinkedList linkedList = (LinkedList) this.oqU.get(str);
        C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", str, Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        AppMethodBeat.m2505o(136927);
    }

    /* renamed from: a */
    public final void mo24438a(String str, C12516a c12516a) {
        AppMethodBeat.m2504i(136928);
        C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", str);
        if (!this.oqV.containsKey(str)) {
            this.oqV.put(str, new LinkedList());
        }
        if (!((List) this.oqV.get(str)).contains(c12516a)) {
            ((LinkedList) this.oqV.get(str)).add(c12516a);
        }
        AppMethodBeat.m2505o(136928);
    }

    /* renamed from: QC */
    public final void mo24435QC(String str) {
        AppMethodBeat.m2504i(136929);
        C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", str);
        if (!this.oqV.containsKey(str)) {
            C4990ab.m7421w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", str);
        }
        LinkedList linkedList = (LinkedList) this.oqV.get(str);
        C4990ab.m7417i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", str, Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        AppMethodBeat.m2505o(136929);
    }

    /* renamed from: a */
    public final CharSequence mo24437a(String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.m2504i(136930);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
            AppMethodBeat.m2505o(136930);
            return null;
        }
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            C4990ab.m7416i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
            AppMethodBeat.m2505o(136930);
            return null;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (C5046bo.isNullOrNil(str2) || !"sysmsgtemplate".equals(str2)) {
            C4990ab.m7421w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", str2);
            AppMethodBeat.m2505o(136930);
            return null;
        }
        CharSequence a = m56608a(z, bundle, (WeakReference) weakReference, 0);
        AppMethodBeat.m2505o(136930);
        return a;
    }

    /* renamed from: QD */
    public final CharSequence mo24436QD(String str) {
        AppMethodBeat.m2504i(136931);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
            AppMethodBeat.m2505o(136931);
            return null;
        }
        Map z = C5049br.m7595z(str, "sysmsg");
        if (z == null) {
            C4990ab.m7416i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
            AppMethodBeat.m2505o(136931);
            return null;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (C5046bo.isNullOrNil(str2) || !"sysmsgtemplate".equals(str2)) {
            C4990ab.m7421w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", str2);
            AppMethodBeat.m2505o(136931);
            return null;
        }
        CharSequence a = m56608a(z, null, null, 1);
        AppMethodBeat.m2505o(136931);
        return a;
    }

    /* renamed from: a */
    private CharSequence m56608a(Map<String, String> map, Bundle bundle, WeakReference<Context> weakReference, int i) {
        CharSequence concactSpannable;
        AppMethodBeat.m2504i(136932);
        String str = ".sysmsg.sysmsgtemplate.content_template";
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String str2 = str + ((i3 == 0 ? "" : Integer.valueOf(i3)));
            if (C5046bo.isNullOrNil((String) map.get(str2))) {
                break;
            }
            if (!C34531a.m56606RD((String) map.get(str2 + ".$type"))) {
                C4990ab.m7421w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", (String) map.get(str2 + ".$type"));
                arrayList.add(C34531a.m56612q(str2, map));
            }
            C4990ab.m7419v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", (String) map.get(str2 + ".template"));
            ArrayList RF = C3451b.m5734RF(r3);
            String str3 = "MicroMsg.SysMsgTemplateImp";
            String str4 = "hy: parsed %d models";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(RF == null ? 0 : RF.size());
            C4990ab.m7411d(str3, str4, objArr);
            if (RF == null || RF.size() == 0) {
                arrayList.add(new SpannableString(""));
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = RF.iterator();
                while (it.hasNext()) {
                    C3452a c3452a = (C3452a) it.next();
                    if (c3452a.type == 0) {
                        arrayList2.add(new SpannableString(C44089j.m79292b(C4996ah.getContext(), c3452a.content)));
                    } else if (c3452a.type == 1) {
                        int i4 = 0;
                        while (true) {
                            Object obj;
                            int i5 = i4;
                            str2 = str + ".link_list.link";
                            if (i5 != 0) {
                                obj = str2 + i5;
                            } else {
                                String obj2 = str2;
                            }
                            if (C5046bo.isNullOrNil((String) map.get(obj2))) {
                                break;
                            }
                            if (c3452a.content.equals((String) map.get(obj2 + ".$name"))) {
                                str2 = (String) map.get(obj2 + ".$type");
                                List list;
                                if (i == 0) {
                                    list = (List) this.oqU.get(str2);
                                    C12517b c12517b = (list == null || list.size() <= 0) ? null : (C12517b) ((LinkedList) this.oqU.get(str2)).getLast();
                                    if (!C34531a.m56607RE(str2) || c12517b == null) {
                                        String str5 = "MicroMsg.SysMsgTemplateImp";
                                        String str6 = "alvinluo not support link type: %s or listener == null: %b";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = C5046bo.m7532bc(str2, "");
                                        objArr2[1] = Boolean.valueOf(c12517b == null);
                                        C4990ab.m7417i(str5, str6, objArr2);
                                        arrayList2.add(C34531a.m56612q(obj2, map));
                                    } else {
                                        CharSequence a = c12517b.mo7904a(map, obj2, bundle, weakReference);
                                        C34531a.m56605J(a);
                                        arrayList2.add(C34531a.nullAsNil(a));
                                    }
                                } else if (i == 1) {
                                    list = (List) this.oqV.get(str2);
                                    C12516a c12516a = (list == null || list.size() <= 0) ? null : (C12516a) ((LinkedList) this.oqV.get(str2)).getLast();
                                    if (!C34531a.m56607RE(str2) || c12516a == null) {
                                        arrayList2.add(C34531a.m56612q(obj2, map));
                                    } else {
                                        arrayList2.add(C5046bo.nullAsNil(c12516a.mo24443g(map, obj2)));
                                    }
                                } else {
                                    C4990ab.m7412e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
                                }
                            }
                            i4 = i5 + 1;
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
                    }
                }
                C4990ab.m7419v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", C34531a.concactSpannable(arrayList2));
                arrayList.add(concactSpannable);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() == 0) {
            C4990ab.m7420w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.m2505o(136932);
            return spannableString;
        }
        concactSpannable = C34531a.concactSpannable(arrayList);
        AppMethodBeat.m2505o(136932);
        return concactSpannable;
    }

    private static CharSequence nullAsNil(CharSequence charSequence) {
        AppMethodBeat.m2504i(136933);
        if (charSequence == null || charSequence.length() == 0) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.m2505o(136933);
            return spannableString;
        }
        AppMethodBeat.m2505o(136933);
        return charSequence;
    }

    /* renamed from: J */
    private static void m56605J(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.m2504i(136934);
        if (charSequence != null && charSequence.length() > 0 && (charSequence instanceof Spanned)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                int length = clickableSpanArr.length;
                while (i < length) {
                    if (clickableSpanArr[i] instanceof C30375a) {
                        i++;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
                        AppMethodBeat.m2505o(136934);
                        throw illegalArgumentException;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(136934);
    }

    private static CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.m2504i(136935);
        CharSequence spannableString = new SpannableString("");
        Iterator it = arrayList.iterator();
        while (true) {
            CharSequence charSequence = spannableString;
            if (it.hasNext()) {
                spannableString = (CharSequence) it.next();
                spannableString = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
            } else {
                AppMethodBeat.m2505o(136935);
                return charSequence;
            }
        }
    }

    /* renamed from: q */
    private static CharSequence m56612q(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(136936);
        if ((C5046bo.getInt((String) map.get(new StringBuilder().append(str).append(".$hidden").toString()), 0) == 1 ? 1 : 0) != 0) {
            C4990ab.m7418v("MicroMsg.SysMsgTemplateImp", "hy: hide");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.m2505o(136936);
            return spannableString;
        }
        CharSequence spannableString2 = new SpannableString(C44089j.m79292b(C4996ah.getContext(), C5046bo.nullAsNil((String) map.get(str + ".plain"))));
        AppMethodBeat.m2505o(136936);
        return spannableString2;
    }

    /* renamed from: RD */
    private static boolean m56606RD(String str) {
        AppMethodBeat.m2504i(136937);
        if ("tmpl_type_profile".equals(str) || "tmpl_type_profilewithrevoke".equals(str) || "tmpl_type_profilewithrevokeqrcode".equals(str) || "tmpl_type_wxappnotifywithview".equals(str) || "tmpl_type_succeed_contact".equals(str) || "tmpl_type_jump_chat".equals(str)) {
            AppMethodBeat.m2505o(136937);
            return true;
        }
        AppMethodBeat.m2505o(136937);
        return false;
    }

    /* renamed from: RE */
    private static boolean m56607RE(String str) {
        AppMethodBeat.m2504i(136938);
        if ("link_profile".equals(str) || "link_revoke".equals(str) || "link_revoke_qrcode".equals(str) || "link_plain".equals(str) || "link_view_wxapp".equals(str) || "link_succeed_contact".equals(str) || "link_jump_chat".equals(str) || "link_admin_explain".equals(str)) {
            AppMethodBeat.m2505o(136938);
            return true;
        }
        AppMethodBeat.m2505o(136938);
        return false;
    }
}
