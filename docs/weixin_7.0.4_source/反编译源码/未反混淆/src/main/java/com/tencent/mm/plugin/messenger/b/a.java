package com.tencent.mm.plugin.messenger.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a implements e {
    private Map<String, LinkedList<b>> oqU = new HashMap();
    private Map<String, LinkedList<com.tencent.mm.plugin.messenger.a.e.a>> oqV = new HashMap();
    private Map<String, HashSet<c>> oqW = new HashMap();
    private com.tencent.mm.at.a.d.a<Long, CharSequence> oqX = new com.tencent.mm.at.a.d.a(200);
    private com.tencent.mm.at.a.d.a<Long, CharSequence> oqY = new com.tencent.mm.at.a.d.a(500);
    public o oqZ = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(136919);
            ab.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", map.toString());
            a.a(a.this, str, (Map) map, aVar);
            AppMethodBeat.o(136919);
        }
    };

    public a() {
        AppMethodBeat.i(136923);
        AppMethodBeat.o(136923);
    }

    public final void a(final String str, final c cVar) {
        AppMethodBeat.i(136924);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136920);
                ab.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", str);
                HashSet hashSet = (HashSet) a.this.oqW.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                if (!hashSet.contains(cVar)) {
                    hashSet.add(cVar);
                }
                a.this.oqW.put(str, hashSet);
                AppMethodBeat.o(136920);
            }
        });
        AppMethodBeat.o(136924);
    }

    public final void b(final String str, final c cVar) {
        AppMethodBeat.i(136925);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136921);
                ab.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", str);
                HashSet hashSet = (HashSet) a.this.oqW.get(str);
                if (hashSet == null) {
                    AppMethodBeat.o(136921);
                    return;
                }
                hashSet.remove(cVar);
                if (hashSet.size() == 0) {
                    a.this.oqW.remove(str);
                    AppMethodBeat.o(136921);
                    return;
                }
                a.this.oqW.put(str, hashSet);
                AppMethodBeat.o(136921);
            }
        });
        AppMethodBeat.o(136925);
    }

    public final void a(String str, b bVar) {
        AppMethodBeat.i(136926);
        ab.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", str);
        if (!this.oqU.containsKey(str)) {
            this.oqU.put(str, new LinkedList());
        }
        if (!((List) this.oqU.get(str)).contains(bVar)) {
            ((LinkedList) this.oqU.get(str)).add(bVar);
        }
        AppMethodBeat.o(136926);
    }

    public final void QB(String str) {
        AppMethodBeat.i(136927);
        ab.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", str);
        if (!this.oqU.containsKey(str)) {
            ab.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", str);
        }
        LinkedList linkedList = (LinkedList) this.oqU.get(str);
        ab.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", str, Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        AppMethodBeat.o(136927);
    }

    public final void a(String str, com.tencent.mm.plugin.messenger.a.e.a aVar) {
        AppMethodBeat.i(136928);
        ab.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", str);
        if (!this.oqV.containsKey(str)) {
            this.oqV.put(str, new LinkedList());
        }
        if (!((List) this.oqV.get(str)).contains(aVar)) {
            ((LinkedList) this.oqV.get(str)).add(aVar);
        }
        AppMethodBeat.o(136928);
    }

    public final void QC(String str) {
        AppMethodBeat.i(136929);
        ab.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", str);
        if (!this.oqV.containsKey(str)) {
            ab.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", str);
        }
        LinkedList linkedList = (LinkedList) this.oqV.get(str);
        ab.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", str, Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            linkedList.removeLast();
        }
        AppMethodBeat.o(136929);
    }

    public final CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.i(136930);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
            AppMethodBeat.o(136930);
            return null;
        }
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            ab.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
            AppMethodBeat.o(136930);
            return null;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (bo.isNullOrNil(str2) || !"sysmsgtemplate".equals(str2)) {
            ab.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", str2);
            AppMethodBeat.o(136930);
            return null;
        }
        CharSequence a = a(z, bundle, (WeakReference) weakReference, 0);
        AppMethodBeat.o(136930);
        return a;
    }

    public final CharSequence QD(String str) {
        AppMethodBeat.i(136931);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
            AppMethodBeat.o(136931);
            return null;
        }
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            ab.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
            AppMethodBeat.o(136931);
            return null;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        if (bo.isNullOrNil(str2) || !"sysmsgtemplate".equals(str2)) {
            ab.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", str2);
            AppMethodBeat.o(136931);
            return null;
        }
        CharSequence a = a(z, null, null, 1);
        AppMethodBeat.o(136931);
        return a;
    }

    private CharSequence a(Map<String, String> map, Bundle bundle, WeakReference<Context> weakReference, int i) {
        CharSequence concactSpannable;
        AppMethodBeat.i(136932);
        String str = ".sysmsg.sysmsgtemplate.content_template";
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String str2 = str + ((i3 == 0 ? "" : Integer.valueOf(i3)));
            if (bo.isNullOrNil((String) map.get(str2))) {
                break;
            }
            if (!RD((String) map.get(str2 + ".$type"))) {
                ab.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", (String) map.get(str2 + ".$type"));
                arrayList.add(q(str2, map));
            }
            ab.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", (String) map.get(str2 + ".template"));
            ArrayList RF = b.RF(r3);
            String str3 = "MicroMsg.SysMsgTemplateImp";
            String str4 = "hy: parsed %d models";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(RF == null ? 0 : RF.size());
            ab.d(str3, str4, objArr);
            if (RF == null || RF.size() == 0) {
                arrayList.add(new SpannableString(""));
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = RF.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.messenger.b.b.a aVar = (com.tencent.mm.plugin.messenger.b.b.a) it.next();
                    if (aVar.type == 0) {
                        arrayList2.add(new SpannableString(j.b(ah.getContext(), aVar.content)));
                    } else if (aVar.type == 1) {
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
                            if (bo.isNullOrNil((String) map.get(obj2))) {
                                break;
                            }
                            if (aVar.content.equals((String) map.get(obj2 + ".$name"))) {
                                str2 = (String) map.get(obj2 + ".$type");
                                List list;
                                if (i == 0) {
                                    list = (List) this.oqU.get(str2);
                                    b bVar = (list == null || list.size() <= 0) ? null : (b) ((LinkedList) this.oqU.get(str2)).getLast();
                                    if (!RE(str2) || bVar == null) {
                                        String str5 = "MicroMsg.SysMsgTemplateImp";
                                        String str6 = "alvinluo not support link type: %s or listener == null: %b";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = bo.bc(str2, "");
                                        objArr2[1] = Boolean.valueOf(bVar == null);
                                        ab.i(str5, str6, objArr2);
                                        arrayList2.add(q(obj2, map));
                                    } else {
                                        CharSequence a = bVar.a(map, obj2, bundle, weakReference);
                                        J(a);
                                        arrayList2.add(nullAsNil(a));
                                    }
                                } else if (i == 1) {
                                    list = (List) this.oqV.get(str2);
                                    com.tencent.mm.plugin.messenger.a.e.a aVar2 = (list == null || list.size() <= 0) ? null : (com.tencent.mm.plugin.messenger.a.e.a) ((LinkedList) this.oqV.get(str2)).getLast();
                                    if (!RE(str2) || aVar2 == null) {
                                        arrayList2.add(q(obj2, map));
                                    } else {
                                        arrayList2.add(bo.nullAsNil(aVar2.g(map, obj2)));
                                    }
                                } else {
                                    ab.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
                                }
                            }
                            i4 = i5 + 1;
                        }
                    } else {
                        ab.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
                    }
                }
                ab.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", concactSpannable(arrayList2));
                arrayList.add(concactSpannable);
            }
            i2 = i3 + 1;
        }
        if (arrayList.size() == 0) {
            ab.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(136932);
            return spannableString;
        }
        concactSpannable = concactSpannable(arrayList);
        AppMethodBeat.o(136932);
        return concactSpannable;
    }

    private static CharSequence nullAsNil(CharSequence charSequence) {
        AppMethodBeat.i(136933);
        if (charSequence == null || charSequence.length() == 0) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(136933);
            return spannableString;
        }
        AppMethodBeat.o(136933);
        return charSequence;
    }

    private static void J(CharSequence charSequence) {
        int i = 0;
        AppMethodBeat.i(136934);
        if (charSequence != null && charSequence.length() > 0 && (charSequence instanceof Spanned)) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                int length = clickableSpanArr.length;
                while (i < length) {
                    if (clickableSpanArr[i] instanceof com.tencent.mm.ui.base.a.a) {
                        i++;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
                        AppMethodBeat.o(136934);
                        throw illegalArgumentException;
                    }
                }
            }
        }
        AppMethodBeat.o(136934);
    }

    private static CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.i(136935);
        CharSequence spannableString = new SpannableString("");
        Iterator it = arrayList.iterator();
        while (true) {
            CharSequence charSequence = spannableString;
            if (it.hasNext()) {
                spannableString = (CharSequence) it.next();
                spannableString = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
            } else {
                AppMethodBeat.o(136935);
                return charSequence;
            }
        }
    }

    private static CharSequence q(String str, Map<String, String> map) {
        AppMethodBeat.i(136936);
        if ((bo.getInt((String) map.get(new StringBuilder().append(str).append(".$hidden").toString()), 0) == 1 ? 1 : 0) != 0) {
            ab.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(136936);
            return spannableString;
        }
        CharSequence spannableString2 = new SpannableString(j.b(ah.getContext(), bo.nullAsNil((String) map.get(str + ".plain"))));
        AppMethodBeat.o(136936);
        return spannableString2;
    }

    private static boolean RD(String str) {
        AppMethodBeat.i(136937);
        if ("tmpl_type_profile".equals(str) || "tmpl_type_profilewithrevoke".equals(str) || "tmpl_type_profilewithrevokeqrcode".equals(str) || "tmpl_type_wxappnotifywithview".equals(str) || "tmpl_type_succeed_contact".equals(str) || "tmpl_type_jump_chat".equals(str)) {
            AppMethodBeat.o(136937);
            return true;
        }
        AppMethodBeat.o(136937);
        return false;
    }

    private static boolean RE(String str) {
        AppMethodBeat.i(136938);
        if ("link_profile".equals(str) || "link_revoke".equals(str) || "link_revoke_qrcode".equals(str) || "link_plain".equals(str) || "link_view_wxapp".equals(str) || "link_succeed_contact".equals(str) || "link_jump_chat".equals(str) || "link_admin_explain".equals(str)) {
            AppMethodBeat.o(136938);
            return true;
        }
        AppMethodBeat.o(136938);
        return false;
    }
}
