package com.tencent.mm.plugin.messenger;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.h;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class PluginMessenger extends f implements com.tencent.mm.ai.f, c, com.tencent.mm.plugin.messenger.a.c {
    private ProgressDialog ehJ = null;
    private a opA = new a() {
        public final String g(Map<String, String> map, String str) {
            AppMethodBeat.i(136886);
            if (map == null) {
                AppMethodBeat.o(136886);
                return null;
            }
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.o(136886);
            return nullAsNil;
        }
    };
    private a opB = new a() {
        public final String g(Map<String, String> map, String str) {
            AppMethodBeat.i(136887);
            if (map == null) {
                AppMethodBeat.o(136887);
                return null;
            }
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.o(136887);
            return nullAsNil;
        }
    };
    private a opC = new a() {
        public final String g(Map<String, String> map, String str) {
            AppMethodBeat.i(136888);
            if (map == null) {
                AppMethodBeat.o(136888);
                return null;
            }
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.o(136888);
            return nullAsNil;
        }
    };
    private a opD = new a() {
        public final String g(Map<String, String> map, String str) {
            AppMethodBeat.i(136889);
            if (map == null) {
                AppMethodBeat.o(136889);
                return null;
            }
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".title"));
            AppMethodBeat.o(136889);
            return nullAsNil;
        }
    };
    private a opE = new a() {
        public final String g(Map<String, String> map, String str) {
            AppMethodBeat.i(136890);
            StringBuilder stringBuilder = new StringBuilder();
            String bc = bo.bc((String) map.get(str + ".separator"), "、");
            int i = 0;
            while (true) {
                int i2 = i;
                String str2 = str + ".memberlist.member" + (i2 != 0 ? Integer.valueOf(i2) : "");
                if (map.get(str2) != null) {
                    if (i2 != 0) {
                        stringBuilder.append(bc);
                    }
                    str2 = (String) map.get(str2 + ".nickname");
                    if (bo.isNullOrNil(str2)) {
                        ab.w("MicroMsg.PluginMessenger", "hy: can not resolve username or nickname");
                    } else {
                        stringBuilder.append(str2);
                    }
                    i = i2 + 1;
                } else {
                    str2 = stringBuilder.toString();
                    AppMethodBeat.o(136890);
                    return str2;
                }
            }
        }
    };
    private o opF = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, e.a aVar) {
            AppMethodBeat.i(136876);
            if ("secmsg".equals(str)) {
                String nullAsNil = bo.nullAsNil((String) map.get(".sysmsg.secmsg.session"));
                String nullAsNil2 = bo.nullAsNil((String) map.get(".sysmsg.secmsg.newmsgid"));
                int ank = bo.ank((String) map.get(".sysmsg.secmsg.sec_msg_node.sfn"));
                int ank2 = bo.ank((String) map.get(".sysmsg.secmsg.sec_msg_node.fd"));
                String nullAsNil3 = bo.nullAsNil((String) map.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
                int ank3 = bo.ank((String) map.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
                ab.i("MicroMsg.PluginMessenger", "%d,%d,%s,%d,%s", Integer.valueOf(ank), Integer.valueOf(ank2), nullAsNil3, Integer.valueOf(ank3), bo.nullAsNil((String) map.get(".sysmsg.secmsg.sec_msg_node.share-tip-url")));
                if (!bo.Q(nullAsNil, nullAsNil2)) {
                    bi Q = ((j) g.K(j.class)).bOr().Q(nullAsNil, bo.anl(nullAsNil2));
                    if (bo.isNullOrNil(Q.field_talker) || Q.field_msgSvrId <= 0) {
                        ab.i("MicroMsg.PluginMessenger", "msg %s not found!", nullAsNil2);
                    } else if (Q.field_isSend != 1) {
                        bh.a(Q, ank, ank2, nullAsNil3, ank3, r5);
                        AppMethodBeat.o(136876);
                        return;
                    }
                }
            }
            AppMethodBeat.o(136876);
        }
    };
    private q opt;
    a opu = new a();
    private com.tencent.mm.plugin.messenger.b.a opv = new com.tencent.mm.plugin.messenger.b.a();
    private b opw = new b() {
        public final /* synthetic */ CharSequence a(Map map, String str, Bundle bundle, WeakReference weakReference) {
            AppMethodBeat.i(136875);
            if (map == null) {
                AppMethodBeat.o(136875);
                return null;
            }
            CharSequence spannableString = new SpannableString(bo.nullAsNil((String) map.get(str + ".plain")));
            AppMethodBeat.o(136875);
            return spannableString;
        }
    };
    private b opx = new b() {
        public final /* synthetic */ CharSequence a(Map map, String str, Bundle bundle, WeakReference weakReference) {
            AppMethodBeat.i(136882);
            if (map == null) {
                AppMethodBeat.o(136882);
                return null;
            }
            String string;
            if (bundle != null) {
                string = bundle.getString("conv_talker_username");
            } else {
                string = "";
            }
            PluginMessenger.access$000(PluginMessenger.this, map, str, bundle, weakReference, string, false);
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".title"));
            CharSequence spannableString = new SpannableString(nullAsNil);
            final Map map2 = map;
            final String str2 = str;
            final Bundle bundle2 = bundle;
            final WeakReference weakReference2 = weakReference;
            final String str3 = string;
            spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                public final void onClickImp(View view) {
                    AppMethodBeat.i(136881);
                    PluginMessenger.access$000(PluginMessenger.this, map2, str2, bundle2, weakReference2, str3, true);
                    AppMethodBeat.o(136881);
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.o(136882);
            return spannableString;
        }
    };
    private b opy = new b() {
        public final /* synthetic */ CharSequence a(final Map map, final String str, final Bundle bundle, WeakReference weakReference) {
            AppMethodBeat.i(136884);
            if (map == null) {
                AppMethodBeat.o(136884);
                return null;
            }
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".title"));
            CharSequence spannableString = new SpannableString(nullAsNil);
            spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
                public final void onClickImp(View view) {
                    AppMethodBeat.i(136883);
                    try {
                        String string = bundle.getString("send_msg_username", "");
                        String bc = bo.bc((String) map.get(str + ".chatname"), "");
                        v vVar = new v();
                        vVar.eR(string);
                        vVar.cXW = 2;
                        vVar.cXX = 2;
                        vVar.cYa = 1;
                        vVar.ajK();
                        PluginMessenger.access$100(PluginMessenger.this, bc);
                        AppMethodBeat.o(136883);
                    } catch (Throwable th) {
                        AppMethodBeat.o(136883);
                    }
                }
            }, 0, nullAsNil.length(), 33);
            AppMethodBeat.o(136884);
            return spannableString;
        }
    };
    private a opz = new a() {
        public final String g(Map<String, String> map, String str) {
            AppMethodBeat.i(136885);
            if (map == null) {
                AppMethodBeat.o(136885);
                return null;
            }
            String nullAsNil = bo.nullAsNil((String) map.get(str + ".plain"));
            AppMethodBeat.o(136885);
            return nullAsNil;
        }
    };

    public PluginMessenger() {
        AppMethodBeat.i(136891);
        AppMethodBeat.o(136891);
    }

    static /* synthetic */ void access$000(PluginMessenger pluginMessenger, Map map, String str, Bundle bundle, WeakReference weakReference, String str2, boolean z) {
        AppMethodBeat.i(136910);
        pluginMessenger.resolvedSucceedContactText(map, str, bundle, weakReference, str2, z);
        AppMethodBeat.o(136910);
    }

    static /* synthetic */ void access$100(PluginMessenger pluginMessenger, String str) {
        AppMethodBeat.i(136911);
        pluginMessenger.startChattingUI(str);
        AppMethodBeat.o(136911);
    }

    private void resolvedSucceedContactText(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference, String str2, boolean z) {
        AppMethodBeat.i(136892);
        try {
            String bc = bo.bc(bundle.getString("local_session"), "");
            if (!(weakReference == null || weakReference.get() == null)) {
                String str3 = (String) map.get(str + ".window_template.$type");
                int ank = bo.ank((String) map.get(".sysmsg.sysmsgtemplate.content_template.succeed_scene"));
                if ("tmpl_type_succeed_contact_window".equals(str3)) {
                    str3 = (String) map.get(str + ".window_template.template");
                    String str4 = (String) map.get(str + ".window_template.tp_username");
                    String str5 = (String) map.get(str + ".window_template.headimgurl");
                    if (!bo.isNullOrNil(str5) && com.tencent.mm.ah.o.act().qo(str4) == null) {
                        h hVar = new h();
                        hVar.username = str4;
                        hVar.frV = str5;
                        hVar.dtR = 3;
                        hVar.cB(false);
                        com.tencent.mm.ah.o.act().b(hVar);
                    }
                    if (z && isSwitchContact(str4, str2)) {
                        startChattingUI(str4);
                        AppMethodBeat.o(136892);
                        return;
                    }
                    String str6 = (String) map.get(str + ".window_template.ticket");
                    String str7 = (String) map.get(str + ".window_template.antispam_ticket");
                    String str8 = "";
                    String str9 = "";
                    ArrayList RF = com.tencent.mm.plugin.messenger.b.b.RF(str3);
                    if (RF != null && RF.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = RF.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.messenger.b.b.a aVar = (com.tencent.mm.plugin.messenger.b.b.a) it.next();
                            if (aVar != null && aVar.content != null) {
                                if (aVar.type == 0) {
                                    arrayList.add(new SpannableString(com.tencent.mm.pluginsdk.ui.e.j.b(ah.getContext(), aVar.content)));
                                } else if (aVar.type == 1) {
                                    int i = 0;
                                    while (true) {
                                        Object obj;
                                        str3 = str + ".window_template.link_list.link";
                                        if (i != 0) {
                                            obj = str3 + i;
                                        } else {
                                            String obj2 = str3;
                                        }
                                        if (bo.isNullOrNil((String) map.get(obj2))) {
                                            break;
                                        }
                                        str3 = (String) map.get(obj2 + ".$name");
                                        str5 = (String) map.get(obj2 + ".$type");
                                        if (aVar.content.equals(str3) && "link_plain".equals(str5)) {
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
                        v vVar;
                        if (z) {
                            if (ank == 1) {
                                vVar = new v();
                                vVar.eQ(bc);
                                vVar.eR(str2);
                                vVar.cXW = 1;
                                vVar.cXX = 1;
                                vVar.cXY = 3;
                                vVar.ajK();
                            } else if (ank == 0) {
                                vVar = new v();
                                vVar.eQ(bc);
                                vVar.eR(str2);
                                vVar.cXW = 1;
                                vVar.cXX = 1;
                                vVar.cXY = 2;
                                vVar.ajK();
                            }
                            showSwitchContactDialog((Context) weakReference.get(), bc, concactSpannable(arrayList).toString(), str4, str6, str7, str9, str8, str2);
                            AppMethodBeat.o(136892);
                            return;
                        } else if (isFirstSwitchContactTips(str4, str2)) {
                            markFirstSwitchContactTips(str4, str2);
                            vVar = new v();
                            vVar.eQ(bc);
                            vVar.eR(str2);
                            vVar.cXW = 1;
                            vVar.cXX = 1;
                            vVar.cXY = 1;
                            vVar.ajK();
                            showSwitchContactDialog((Context) weakReference.get(), bc, concactSpannable(arrayList).toString(), str4, str6, str7, str9, str8, str2);
                        }
                    }
                }
            }
            AppMethodBeat.o(136892);
        } catch (Throwable th) {
            AppMethodBeat.o(136892);
        }
    }

    public void installed() {
        AppMethodBeat.i(136893);
        alias(com.tencent.mm.plugin.messenger.a.c.class);
        AppMethodBeat.o(136893);
    }

    public void dependency() {
        AppMethodBeat.i(136894);
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        AppMethodBeat.o(136894);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(136895);
        if (gVar.SG()) {
            g.RQ();
            g.a(com.tencent.mm.plugin.messenger.a.b.class, this.opu);
            g.a(com.tencent.mm.plugin.messenger.a.e.class, this.opv);
        }
        AppMethodBeat.o(136895);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(136896);
        if (gVar.SG()) {
            pin(com.tencent.mm.plugin.v.a.ceU());
        }
        AppMethodBeat.o(136896);
    }

    public String toString() {
        return "plugin-messenger";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(136897);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("sysmsgtemplate", this.opv.oqZ);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.opw);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.opx);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.opy);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_plain", this.opz);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_succeed_contact", this.opA);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_jump_chat", this.opB);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke", this.opC);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_qrcode", this.opD);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).a("link_profile", this.opE);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("secmsg", this.opF);
        g.Rg().a(853, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(136897);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(136898);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("sysmsgtemplate", this.opv.oqZ);
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QB("link_plain");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QB("link_succeed_contact");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QB("link_jump_chat");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_plain");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_succeed_contact");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_jump_chat");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_revoke");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_revoke_qrcode");
        ((com.tencent.mm.plugin.messenger.a.e) g.K(com.tencent.mm.plugin.messenger.a.e.class)).QC("link_profile");
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("secmsg", this.opF);
        g.Rg().b(853, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(136898);
    }

    private CharSequence nullAsNil(CharSequence charSequence) {
        AppMethodBeat.i(136899);
        if (charSequence == null || charSequence.length() == 0) {
            SpannableString spannableString = new SpannableString("");
            AppMethodBeat.o(136899);
            return spannableString;
        }
        AppMethodBeat.o(136899);
        return charSequence;
    }

    private CharSequence concactSpannable(ArrayList<CharSequence> arrayList) {
        AppMethodBeat.i(136900);
        CharSequence spannableString = new SpannableString("");
        if (arrayList == null) {
            AppMethodBeat.o(136900);
            return spannableString;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            CharSequence charSequence = spannableString;
            if (it.hasNext()) {
                spannableString = (CharSequence) it.next();
                spannableString = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
            } else {
                AppMethodBeat.o(136900);
                return charSequence;
            }
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(136901);
        try {
            if (com.tencent.mm.sdk.a.b.dnO()) {
                t.makeText(ah.getContext(), String.format("errType %s errCode %s errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
            }
            if (mVar.getType() == 853) {
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                if (mVar.equals(this.opt)) {
                    q qVar = (q) mVar;
                    if (i2 == 0) {
                        saveSwitchContact(qVar.geZ, qVar.gfj);
                        startChattingUI(qVar.geZ);
                    }
                    ab.w("MicroMsg.PluginMessenger", "onSceneEnd VerifyOpenIMContact errCode: " + i2 + " errType: " + i + " userName: " + qVar.geZ + " ticket: " + qVar.gfi + " talkerUsername: " + qVar.gfj);
                }
            }
            AppMethodBeat.o(136901);
        } catch (Throwable th) {
            ab.e("MicroMsg.PluginMessenger", "onSceneEnd ".concat(String.valueOf(th)));
            AppMethodBeat.o(136901);
        }
    }

    private void startChattingUI(String str) {
        AppMethodBeat.i(136902);
        ab.i("MicroMsg.PluginMessenger", "startChattingUI userName: ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("Chat_Mode", 1);
        d.f(ah.getContext(), ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(136902);
    }

    public void showSwitchContactDialog(final Context context, final String str, String str2, final String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(136903);
        com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(context);
        SwitchContactDialogCustomView switchContactDialogCustomView = new SwitchContactDialogCustomView(context);
        switchContactDialogCustomView.setTilte(context.getString(R.string.db0));
        switchContactDialogCustomView.setContent(str2);
        switchContactDialogCustomView.setDesc(str6);
        switchContactDialogCustomView.setSubDesc("@".concat(String.valueOf(str7)));
        switchContactDialogCustomView.setPhoto(str3);
        final String str9 = str5;
        switchContactDialogCustomView.setOnPhotoOnClick(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136877);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str3);
                intent.putExtra(com.tencent.mm.ui.e.b.yfT, str9);
                d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 0);
                AppMethodBeat.o(136877);
            }
        });
        com.tencent.mm.ui.widget.a.e.a Qg = aVar.fo(switchContactDialogCustomView).Qg(R.string.daz);
        Qg.zQK = context.getString(R.string.dax);
        str9 = str8;
        final String str10 = str3;
        final String str11 = str;
        final String str12 = str8;
        final String str13 = str4;
        final Context context2 = context;
        Qg.a(new com.tencent.mm.ui.widget.a.e.c() {
            public final void d(boolean z, String str) {
                AppMethodBeat.i(136878);
                v vVar = new v();
                vVar.eQ(str);
                vVar.eR(str9);
                vVar.cXW = 1;
                vVar.cXX = 1;
                vVar.cXZ = 1;
                vVar.ajK();
                AppMethodBeat.o(136878);
            }
        }, new com.tencent.mm.ui.widget.a.e.c() {
            public final void d(boolean z, String str) {
                AppMethodBeat.i(136880);
                if (z && ad.aox(str10)) {
                    v vVar = new v();
                    vVar.eQ(str11);
                    vVar.cXW = 1;
                    vVar.eR(str12);
                    vVar.cXX = 1;
                    vVar.cXZ = 2;
                    vVar.ajK();
                    PluginMessenger.this.opt = new q(str10, str13);
                    PluginMessenger.this.opt.gfj = str12;
                    g.Rg().a(PluginMessenger.this.opt, 0);
                    PluginMessenger pluginMessenger = PluginMessenger.this;
                    Context context = context2;
                    context2.getString(R.string.tz);
                    pluginMessenger.ehJ = com.tencent.mm.ui.base.h.b(context, context2.getString(R.string.db1), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(136879);
                            g.Rg().c(PluginMessenger.this.opt);
                            AppMethodBeat.o(136879);
                        }
                    });
                }
                AppMethodBeat.o(136880);
            }
        }).show();
        AppMethodBeat.o(136903);
    }

    private String getFirstSwitchContactTipsPrefsKey(String str, String str2) {
        AppMethodBeat.i(136904);
        String str3 = "FirstSwitchContactTips_" + str + "_" + str2 + "_" + ((String) g.RP().Ry().get(2, (Object) ""));
        AppMethodBeat.o(136904);
        return str3;
    }

    public void markFirstSwitchContactTips(String str, String str2) {
        AppMethodBeat.i(136905);
        ah.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getFirstSwitchContactTipsPrefsKey(str, str2), false).commit();
        AppMethodBeat.o(136905);
    }

    public boolean isFirstSwitchContactTips(String str, String str2) {
        AppMethodBeat.i(136906);
        boolean z = ah.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getFirstSwitchContactTipsPrefsKey(str, str2), true);
        AppMethodBeat.o(136906);
        return z;
    }

    private String getSwitchContactPrefsKey(String str, String str2) {
        AppMethodBeat.i(136907);
        String str3 = "switch_contact_prefs_" + str + "_" + str2 + "_" + ((String) g.RP().Ry().get(2, (Object) ""));
        AppMethodBeat.o(136907);
        return str3;
    }

    private void saveSwitchContact(String str, String str2) {
        AppMethodBeat.i(136908);
        ah.getContext().getSharedPreferences("switch_contact_prefs", 0).edit().putBoolean(getSwitchContactPrefsKey(str, str2), true).commit();
        AppMethodBeat.o(136908);
    }

    private boolean isSwitchContact(String str, String str2) {
        AppMethodBeat.i(136909);
        boolean z = ah.getContext().getSharedPreferences("switch_contact_prefs", 0).getBoolean(getSwitchContactPrefsKey(str, str2), false);
        AppMethodBeat.o(136909);
        return z;
    }
}
