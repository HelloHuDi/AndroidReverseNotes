package com.tencent.p177mm.plugin.messenger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.openim.p716b.C42240q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C32679v;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.messenger.p453b.C3451b;
import com.tencent.p177mm.plugin.messenger.p453b.C3451b.C3452a;
import com.tencent.p177mm.plugin.messenger.p453b.C34531a;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12516a;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12517b;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.messenger.p993a.C39358c;
import com.tencent.p177mm.plugin.p1416v.C29476a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger */
public class PluginMessenger extends C7597f implements C1202f, C9562c, C39358c {
    private ProgressDialog ehJ = null;
    private C12516a opA = new C367909();
    private C12516a opB = new C2848610();
    private C12516a opC = new C2127311();
    private C12516a opD = new C3935712();
    private C12516a opE = new C4607013();
    private C3473o opF = new C69692();
    private C42240q opt;
    C36791a opu = new C36791a();
    private C34531a opv = new C34531a();
    private C12517b opw = new C34501();
    private C12517b opx = new C345276();
    private C12517b opy = new C412967();
    private C12516a opz = new C367898();

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$1 */
    class C34501 implements C12517b {
        C34501() {
        }

        /* renamed from: a */
        public final /* synthetic */ CharSequence mo7904a(Map map, String str, Bundle bundle, WeakReference weakReference) {
            AppMethodBeat.m2504i(136875);
            if (map == null) {
                AppMethodBeat.m2505o(136875);
                return null;
            }
            CharSequence spannableString = new SpannableString(C5046bo.nullAsNil((String) map.get(str + ".plain")));
            AppMethodBeat.m2505o(136875);
            return spannableString;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$2 */
    class C69692 implements C3473o {
        C69692() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(136876);
            if ("secmsg".equals(str)) {
                String nullAsNil = C5046bo.nullAsNil((String) map.get(".sysmsg.secmsg.session"));
                String nullAsNil2 = C5046bo.nullAsNil((String) map.get(".sysmsg.secmsg.newmsgid"));
                int ank = C5046bo.ank((String) map.get(".sysmsg.secmsg.sec_msg_node.sfn"));
                int ank2 = C5046bo.ank((String) map.get(".sysmsg.secmsg.sec_msg_node.fd"));
                String nullAsNil3 = C5046bo.nullAsNil((String) map.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
                int ank3 = C5046bo.ank((String) map.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
                C4990ab.m7417i("MicroMsg.PluginMessenger", "%d,%d,%s,%d,%s", Integer.valueOf(ank), Integer.valueOf(ank2), nullAsNil3, Integer.valueOf(ank3), C5046bo.nullAsNil((String) map.get(".sysmsg.secmsg.sec_msg_node.share-tip-url")));
                if (!C5046bo.m7510Q(nullAsNil, nullAsNil2)) {
                    C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(nullAsNil, C5046bo.anl(nullAsNil2));
                    if (C5046bo.isNullOrNil(Q.field_talker) || Q.field_msgSvrId <= 0) {
                        C4990ab.m7417i("MicroMsg.PluginMessenger", "msg %s not found!", nullAsNil2);
                    } else if (Q.field_isSend != 1) {
                        C1831bh.m3768a(Q, ank, ank2, nullAsNil3, ank3, r5);
                        AppMethodBeat.m2505o(136876);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(136876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$11 */
    class C2127311 implements C12516a {
        C2127311() {
        }

        /* renamed from: g */
        public final String mo24443g(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(136888);
            if (map == null) {
                AppMethodBeat.m2505o(136888);
                return null;
            }
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.m2505o(136888);
            return nullAsNil;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$10 */
    class C2848610 implements C12516a {
        C2848610() {
        }

        /* renamed from: g */
        public final String mo24443g(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(136887);
            if (map == null) {
                AppMethodBeat.m2505o(136887);
                return null;
            }
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.m2505o(136887);
            return nullAsNil;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$6 */
    class C345276 implements C12517b {
        C345276() {
        }

        /* renamed from: a */
        public final /* synthetic */ CharSequence mo7904a(Map map, String str, Bundle bundle, WeakReference weakReference) {
            AppMethodBeat.m2504i(136882);
            if (map == null) {
                AppMethodBeat.m2505o(136882);
                return null;
            }
            String string;
            if (bundle != null) {
                string = bundle.getString("conv_talker_username");
            } else {
                string = "";
            }
            PluginMessenger.access$000(PluginMessenger.this, map, str, bundle, weakReference, string, false);
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".title"));
            CharSequence spannableString = new SpannableString(nullAsNil);
            final Map map2 = map;
            final String str2 = str;
            final Bundle bundle2 = bundle;
            final WeakReference weakReference2 = weakReference;
            final String str3 = string;
            spannableString.setSpan(new C34529a() {
                public final void onClickImp(View view) {
                    AppMethodBeat.m2504i(136881);
                    PluginMessenger.access$000(PluginMessenger.this, map2, str2, bundle2, weakReference2, str3, true);
                    AppMethodBeat.m2505o(136881);
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.m2505o(136882);
            return spannableString;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$8 */
    class C367898 implements C12516a {
        C367898() {
        }

        /* renamed from: g */
        public final String mo24443g(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(136885);
            if (map == null) {
                AppMethodBeat.m2505o(136885);
                return null;
            }
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".plain"));
            AppMethodBeat.m2505o(136885);
            return nullAsNil;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$9 */
    class C367909 implements C12516a {
        C367909() {
        }

        /* renamed from: g */
        public final String mo24443g(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(136886);
            if (map == null) {
                AppMethodBeat.m2505o(136886);
                return null;
            }
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.m2505o(136886);
            return nullAsNil;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$12 */
    class C3935712 implements C12516a {
        C3935712() {
        }

        /* renamed from: g */
        public final String mo24443g(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(136889);
            if (map == null) {
                AppMethodBeat.m2505o(136889);
                return null;
            }
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.m2505o(136889);
            return nullAsNil;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$7 */
    class C412967 implements C12517b {
        C412967() {
        }

        /* renamed from: a */
        public final /* synthetic */ CharSequence mo7904a(final Map map, final String str, final Bundle bundle, WeakReference weakReference) {
            AppMethodBeat.m2504i(136884);
            if (map == null) {
                AppMethodBeat.m2505o(136884);
                return null;
            }
            String nullAsNil = C5046bo.nullAsNil((String) map.get(str + ".title"));
            CharSequence spannableString = new SpannableString(nullAsNil);
            spannableString.setSpan(new C34529a() {
                public final void onClickImp(View view) {
                    AppMethodBeat.m2504i(136883);
                    try {
                        String string = bundle.getString("send_msg_username", "");
                        String bc = C5046bo.m7532bc((String) map.get(str + ".chatname"), "");
                        C32679v c32679v = new C32679v();
                        c32679v.mo53211eR(string);
                        c32679v.cXW = 2;
                        c32679v.cXX = 2;
                        c32679v.cYa = 1;
                        c32679v.ajK();
                        PluginMessenger.access$100(PluginMessenger.this, bc);
                        AppMethodBeat.m2505o(136883);
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(136883);
                    }
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.m2505o(136884);
            return spannableString;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$13 */
    class C4607013 implements C12516a {
        C4607013() {
        }

        /* renamed from: g */
        public final String mo24443g(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(136890);
            StringBuilder stringBuilder = new StringBuilder();
            String bc = C5046bo.m7532bc((String) map.get(str + ".separator"), "、");
            int i = 0;
            while (true) {
                int i2 = i;
                String str2 = str + ".memberlist.member" + (i2 != 0 ? Integer.valueOf(i2) : "");
                if (map.get(str2) != null) {
                    if (i2 != 0) {
                        stringBuilder.append(bc);
                    }
                    str2 = (String) map.get(str2 + ".nickname");
                    if (C5046bo.isNullOrNil(str2)) {
                        C4990ab.m7420w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
                    } else {
                        stringBuilder.append(str2);
                    }
                    i = i2 + 1;
                } else {
                    str2 = stringBuilder.toString();
                    AppMethodBeat.m2505o(136890);
                    return str2;
                }
            }
        }
    }

    public PluginMessenger() {
        AppMethodBeat.m2504i(136891);
        AppMethodBeat.m2505o(136891);
    }

    static /* synthetic */ void access$000(PluginMessenger pluginMessenger, Map map, String str, Bundle bundle, WeakReference weakReference, String str2, boolean z) {
        AppMethodBeat.m2504i(136910);
        pluginMessenger.resolvedSucceedContactText(map, str, bundle, weakReference, str2, z);
        AppMethodBeat.m2505o(136910);
    }

    static /* synthetic */ void access$100(PluginMessenger pluginMessenger, String str) {
        AppMethodBeat.m2504i(136911);
        pluginMessenger.startChattingUI(str);
        AppMethodBeat.m2505o(136911);
    }

    private void resolvedSucceedContactText(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference, String str2, boolean z) {
        AppMethodBeat.m2504i(136892);
        try {
            String bc = C5046bo.m7532bc(bundle.getString("local_session"), "");
            if (!(weakReference == null || weakReference.get() == null)) {
                String str3 = (String) map.get(str + ".window_template.$type");
                int ank = C5046bo.ank((String) map.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
                if ("tmpl_type_succeed_contact_window".equals(str3)) {
                    str3 = (String) map.get(str + ".window_template.template");
                    String str4 = (String) map.get(str + ".window_template.tp_username");
                    String str5 = (String) map.get(str + ".window_template.headimgurl");
                    if (!C5046bo.isNullOrNil(str5) && C17884o.act().mo33392qo(str4) == null) {
                        C17880h c17880h = new C17880h();
                        c17880h.username = str4;
                        c17880h.frV = str5;
                        c17880h.dtR = 3;
                        c17880h.mo33385cB(false);
                        C17884o.act().mo33391b(c17880h);
                    }
                    if (z && isSwitchContact(str4, str2)) {
                        startChattingUI(str4);
                        AppMethodBeat.m2505o(136892);
                        return;
                    }
                    String str6 = (String) map.get(str + ".window_template.ticket");
                    String str7 = (String) map.get(str + ".window_template.antispam_ticket");
                    String str8 = "";
                    String str9 = "";
                    ArrayList RF = C3451b.m5734RF(str3);
                    if (RF != null && RF.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = RF.iterator();
                        while (it.hasNext()) {
                            C3452a c3452a = (C3452a) it.next();
                            if (c3452a != null && c3452a.content != null) {
                                if (c3452a.type == 0) {
                                    arrayList.add(new SpannableString(C44089j.m79292b(C4996ah.getContext(), c3452a.content)));
                                } else if (c3452a.type == 1) {
                                    int i = 0;
                                    while (true) {
                                        Object obj;
                                        str3 = str + ".window_template.link_list.link";
                                        if (i != 0) {
                                            obj = str3 + i;
                                        } else {
                                            String obj2 = str3;
                                        }
                                        if (C5046bo.isNullOrNil((String) map.get(obj2))) {
                                            break;
                                        }
                                        str3 = (String) map.get(obj2 + ".$name");
                                        str5 = (String) map.get(obj2 + ".$type");
                                        if (c3452a.content.equals(str3) && "link_plain".equals(str5)) {
                                            arrayList.add(nullAsNil((CharSequence) map.get(obj2 + ".plain")));
                                        }
                                        if ("company".equals(str3) && "link_userdescid".equals(str5)) {
                                            str8 = nullAsNil((CharSequence) map.get(obj2 + ".userdesc")).toString();
                                        }
                                        if ("nickname".equals(str3) && "link_plain".equals(str5)) {
                                            str3 = nullAsNil((CharSequence) map.get(obj2 + ".plain")).toString();
                                        } else {
                                            str3 = str9;
                                        }
                                        i++;
                                        str9 = str3;
                                    }
                                }
                            }
                        }
                        C32679v c32679v;
                        if (z) {
                            if (ank == 1) {
                                c32679v = new C32679v();
                                c32679v.mo53210eQ(bc);
                                c32679v.mo53211eR(str2);
                                c32679v.cXW = 1;
                                c32679v.cXX = 1;
                                c32679v.cXY = 3;
                                c32679v.ajK();
                            } else if (ank == 0) {
                                c32679v = new C32679v();
                                c32679v.mo53210eQ(bc);
                                c32679v.mo53211eR(str2);
                                c32679v.cXW = 1;
                                c32679v.cXX = 1;
                                c32679v.cXY = 2;
                                c32679v.ajK();
                            }
                            showSwitchContactDialog((Context) weakReference.get(), bc, concactSpannable(arrayList).toString(), str4, str6, str7, str9, str8, str2);
                            AppMethodBeat.m2505o(136892);
                            return;
                        } else if (isFirstSwitchContactTips(str4, str2)) {
                            markFirstSwitchContactTips(str4, str2);
                            c32679v = new C32679v();
                            c32679v.mo53210eQ(bc);
                            c32679v.mo53211eR(str2);
                            c32679v.cXW = 1;
                            c32679v.cXX = 1;
                            c32679v.cXY = 1;
                            c32679v.ajK();
                            showSwitchContactDialog((Context) weakReference.get(), bc, concactSpannable(arrayList).toString(), str4, str6, str7, str9, str8, str2);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(136892);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(136892);
        }
    }

    public void installed() {
        AppMethodBeat.m2504i(136893);
        alias(C39358c.class);
        AppMethodBeat.m2505o(136893);
    }

    public void dependency() {
        AppMethodBeat.m2504i(136894);
        dependsOn(C27697a.class);
        AppMethodBeat.m2505o(136894);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(136895);
        if (c1681g.mo5181SG()) {
            C1720g.m3537RQ();
            C1720g.m3542a(C34530b.class, this.opu);
            C1720g.m3542a(C12514e.class, this.opv);
        }
        AppMethodBeat.m2505o(136895);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(136896);
        if (c1681g.mo5181SG()) {
            pin(C29476a.ceU());
        }
        AppMethodBeat.m2505o(136896);
    }

    public String toString() {
        return "plugin-messenger";
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(136897);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("sysmsgtemplate", this.opv.oqZ);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24439a("link_plain", this.opw);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24439a("link_succeed_contact", this.opx);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24439a("link_jump_chat", this.opy);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_plain", this.opz);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_succeed_contact", this.opA);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_jump_chat", this.opB);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_revoke", this.opC);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_revoke_qrcode", this.opD);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24438a("link_profile", this.opE);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("secmsg", this.opF);
        C1720g.m3540Rg().mo14539a(853, (C1202f) this);
        AppMethodBeat.m2505o(136897);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(136898);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("sysmsgtemplate", this.opv.oqZ);
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24434QB("link_plain");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24434QB("link_succeed_contact");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24434QB("link_jump_chat");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_plain");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_succeed_contact");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_jump_chat");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_revoke");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_revoke_qrcode");
        ((C12514e) C1720g.m3528K(C12514e.class)).mo24435QC("link_profile");
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("secmsg", this.opF);
        C1720g.m3540Rg().mo14546b(853, (C1202f) this);
        AppMethodBeat.m2505o(136898);
    }

    private CharSequence nullAsNil(CharSequence charSequence) {
        AppMethodBeat.m2504i(136899);
        if (charSequence == null || charSequence.length() == 0) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.m2505o(136899);
            return spannableString;
        }
        AppMethodBeat.m2505o(136899);
        return charSequence;
    }

    private CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.m2504i(136900);
        CharSequence spannableString = new SpannableString("");
        if (arrayList == null) {
            AppMethodBeat.m2505o(136900);
            return spannableString;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            CharSequence charSequence = spannableString;
            if (it.hasNext()) {
                spannableString = (CharSequence) it.next();
                spannableString = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
            } else {
                AppMethodBeat.m2505o(136900);
                return charSequence;
            }
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(136901);
        try {
            if (C4872b.dnO()) {
                C23639t.makeText(C4996ah.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
            }
            if (c1207m.getType() == 853) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (c1207m.equals(this.opt)) {
                    C42240q c42240q = (C42240q) c1207m;
                    if (i2 == 0) {
                        saveSwitchContact(c42240q.geZ, c42240q.gfj);
                        startChattingUI(c42240q.geZ);
                    }
                    C4990ab.m7420w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + i2 + " errType: " + i + " userName: " + c42240q.geZ + " ticket: " + c42240q.gfi + " talkerUsername: " + c42240q.gfj);
                }
            }
            AppMethodBeat.m2505o(136901);
        } catch (Throwable th) {
            C4990ab.m7412e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(th)));
            AppMethodBeat.m2505o(136901);
        }
    }

    private void startChattingUI(String str) {
        AppMethodBeat.m2504i(136902);
        C4990ab.m7416i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("Chat_Mode", 1);
        C25985d.m41473f(C4996ah.getContext(), ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.m2505o(136902);
    }

    public void showSwitchContactDialog(final Context context, final String str, String str2, final String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.m2504i(136903);
        C5659a c5659a = new C5659a(context);
        SwitchContactDialogCustomView switchContactDialogCustomView = new SwitchContactDialogCustomView(context);
        switchContactDialogCustomView.setTilte(context.getString(C25738R.string.db0));
        switchContactDialogCustomView.setContent(str2);
        switchContactDialogCustomView.setDesc(str6);
        switchContactDialogCustomView.setSubDesc("@".concat(String.valueOf(str7)));
        switchContactDialogCustomView.setPhoto(str3);
        final String str9 = str5;
        switchContactDialogCustomView.setOnPhotoOnClick(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(136877);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str3);
                intent.putExtra(C5495b.yfT, str9);
                C25985d.m41468b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 0);
                AppMethodBeat.m2505o(136877);
            }
        });
        C5659a Qg = c5659a.mo11524fo(switchContactDialogCustomView).mo11509Qg(C25738R.string.daz);
        Qg.zQK = context.getString(C25738R.string.dax);
        str9 = str8;
        final String str10 = str3;
        final String str11 = str;
        final String str12 = str8;
        final String str13 = str4;
        final Context context2 = context;
        Qg.mo11513a(new C5662c() {
            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(136878);
                C32679v c32679v = new C32679v();
                c32679v.mo53210eQ(str);
                c32679v.mo53211eR(str9);
                c32679v.cXW = 1;
                c32679v.cXX = 1;
                c32679v.cXZ = 1;
                c32679v.ajK();
                AppMethodBeat.m2505o(136878);
            }
        }, new C5662c() {

            /* renamed from: com.tencent.mm.plugin.messenger.PluginMessenger$5$1 */
            class C69721 implements OnCancelListener {
                C69721() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(136879);
                    C1720g.m3540Rg().mo14547c(PluginMessenger.this.opt);
                    AppMethodBeat.m2505o(136879);
                }
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(136880);
                if (z && C7616ad.aox(str10)) {
                    C32679v c32679v = new C32679v();
                    c32679v.mo53210eQ(str11);
                    c32679v.cXW = 1;
                    c32679v.mo53211eR(str12);
                    c32679v.cXX = 1;
                    c32679v.cXZ = 2;
                    c32679v.ajK();
                    PluginMessenger.this.opt = new C42240q(str10, str13);
                    PluginMessenger.this.opt.gfj = str12;
                    C1720g.m3540Rg().mo14541a(PluginMessenger.this.opt, 0);
                    PluginMessenger pluginMessenger = PluginMessenger.this;
                    Context context = context2;
                    context2.getString(C25738R.string.f9238tz);
                    pluginMessenger.ehJ = C30379h.m48458b(context, context2.getString(C25738R.string.db1), true, new C69721());
                }
                AppMethodBeat.m2505o(136880);
            }
        }).show();
        AppMethodBeat.m2505o(136903);
    }

    private String getFirstSwitchContactTipsPrefsKey(String str, String str2) {
        AppMethodBeat.m2504i(136904);
        String str3 = "FirstSwitchContactTips_" + str + "_" + str2 + "_" + ((String) C1720g.m3536RP().mo5239Ry().get(2, (Object) ""));
        AppMethodBeat.m2505o(136904);
        return str3;
    }

    public void markFirstSwitchContactTips(String str, String str2) {
        AppMethodBeat.m2504i(136905);
        C4996ah.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(str, str2), false).commit();
        AppMethodBeat.m2505o(136905);
    }

    public boolean isFirstSwitchContactTips(String str, String str2) {
        AppMethodBeat.m2504i(136906);
        boolean z = C4996ah.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(str, str2), true);
        AppMethodBeat.m2505o(136906);
        return z;
    }

    private String getSwitchContactPrefsKey(String str, String str2) {
        AppMethodBeat.m2504i(136907);
        String str3 = "switch_contact_prefs_" + str + "_" + str2 + "_" + ((String) C1720g.m3536RP().mo5239Ry().get(2, (Object) ""));
        AppMethodBeat.m2505o(136907);
        return str3;
    }

    private void saveSwitchContact(String str, String str2) {
        AppMethodBeat.m2504i(136908);
        C4996ah.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(str, str2), true).commit();
        AppMethodBeat.m2505o(136908);
    }

    private boolean isSwitchContact(String str, String str2) {
        AppMethodBeat.m2504i(136909);
        boolean z = C4996ah.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(str, str2), false);
        AppMethodBeat.m2505o(136909);
        return z;
    }
}
