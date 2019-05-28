package com.tencent.mm.ui.voicesearch;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VoiceSearchResultUI extends MMActivity {
    private int cKB = 2;
    private TextView kxK;
    private int lRx = -1;
    int showType = 1;
    private b zLE;
    private String[] zLF;
    private boolean zLG = false;
    boolean zLH = false;
    private ListView zLr;
    private String zLt = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35371);
        super.onCreate(bundle);
        initView();
        this.zLG = false;
        AppMethodBeat.o(35371);
    }

    public final void initView() {
        AppMethodBeat.i(35372);
        this.zLr = (ListView) findViewById(R.id.f2b);
        this.kxK = (TextView) findViewById(R.id.n4);
        this.zLF = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.zLt = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.lRx = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.cKB = this.showType == 1 ? 2 : 1;
        this.zLH = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        ab.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", Integer.valueOf(this.showType), Boolean.valueOf(this.zLH));
        this.zLE = new b(getApplicationContext(), this.showType);
        this.zLE.qV(false);
        dHz();
        this.zLr.setAdapter(this.zLE);
        this.kxK.setVisibility(8);
        ab.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.lRx);
        if (this.showType == 2) {
            setMMTitle("");
            this.zLF = U(this.zLF);
        } else {
            setMMTitle(getString(R.string.f37));
        }
        setMMTitle(getString(R.string.f37));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(35369);
                if (!VoiceSearchResultUI.this.zLG) {
                    h.pYm.X(10452, VoiceSearchResultUI.this.cKB + "," + VoiceSearchResultUI.this.lRx + "," + (VoiceSearchResultUI.this.zLF == null ? 0 : VoiceSearchResultUI.this.zLF.length) + ",0");
                }
                if (VoiceSearchResultUI.this.zLH) {
                    VoiceSearchResultUI.this.moveTaskToBack(true);
                }
                VoiceSearchResultUI.this.finish();
                AppMethodBeat.o(35369);
                return true;
            }
        });
        this.zLr.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(35370);
                if (!VoiceSearchResultUI.this.zLG) {
                    int i2;
                    h hVar = h.pYm;
                    StringBuilder append = new StringBuilder().append(VoiceSearchResultUI.this.cKB).append(",").append(VoiceSearchResultUI.this.lRx).append(",");
                    if (VoiceSearchResultUI.this.zLF == null) {
                        i2 = 0;
                    } else {
                        i2 = VoiceSearchResultUI.this.zLF.length;
                    }
                    hVar.X(10452, append.append(i2).append(",").append(i).toString());
                }
                ad PP = VoiceSearchResultUI.this.zLE.PP(i);
                Context context = VoiceSearchResultUI.this;
                String str = PP.field_username;
                String Oj = PP.Oj();
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(35370);
                    return;
                }
                ab.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact ".concat(String.valueOf(str)));
                Intent intent;
                if (context.showType == 3) {
                    intent = new Intent();
                    intent.putExtra("Select_Conv_User", str);
                    context.setResult(-1, intent);
                    context.finish();
                    AppMethodBeat.o(35370);
                    return;
                }
                if (context.showType != 1 && !t.nJ(str) && !t.mZ(str) && !t.kH(str) && !t.mW(str) && !VoiceSearchResultUI.asA(Oj)) {
                    Intent intent2 = new Intent(context, SearchConversationResultUI.class);
                    intent2.putExtra("SearchConversationResult_User", Oj);
                    context.startActivity(intent2);
                } else if (context.showType == 1) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", str);
                    if (t.mW(str)) {
                        intent.putExtra("Is_group_card", true);
                    }
                    if (str != null && str.length() > 0) {
                        e.a(intent, str);
                        if (context.zLH) {
                            context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            context.finish();
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                    AppMethodBeat.o(35370);
                    return;
                } else if (context.showType == 2) {
                    if (bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.VoiceSearchResultUI", "username is null ".concat(String.valueOf(str)));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.ne(str)) {
                        if (r.YS()) {
                            d.b(context.mController.ylL, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.ng(str)) {
                        if (r.YP()) {
                            d.b(context.mController.ylL, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.nf(str)) {
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.nk(str)) {
                        MMAppMgr.cancelNotification(str);
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.nc(str)) {
                        if (r.Zb()) {
                            context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.np(str)) {
                        if (r.YV()) {
                            intent = new Intent();
                            intent.putExtra("type", 20);
                            d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.nx(str)) {
                        if (r.YW()) {
                            intent = new Intent();
                            intent.putExtra("type", 11);
                            d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.nh(str)) {
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.ni(str)) {
                        if (r.YY()) {
                            d.b(context, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.no(str)) {
                        if (r.YT()) {
                            context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                            AppMethodBeat.o(35370);
                            return;
                        }
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else if (t.nm(str) || t.nn(str) || t.nj(str) || t.nr(str) || t.ns(str) || t.nd(str) || t.nA(str)) {
                        d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                        AppMethodBeat.o(35370);
                        return;
                    } else {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        AppMethodBeat.o(35370);
                        return;
                    }
                }
                AppMethodBeat.o(35370);
            }
        });
        V(this.zLF);
        AppMethodBeat.o(35372);
    }

    private static String[] U(String[] strArr) {
        AppMethodBeat.i(35373);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(35373);
            return strArr;
        }
        ab.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            String mJ = s.mJ(str);
            ab.d("MicroMsg.VoiceSearchResultUI", "displayname ".concat(String.valueOf(mJ)));
            if (!hashMap.containsValue(mJ) || !t.kH(str)) {
                ab.d("MicroMsg.VoiceSearchResultUI", "username ".concat(String.valueOf(str)));
                hashMap.put(mJ, str);
                arrayList.add(str);
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(35373);
        return strArr2;
    }

    public void onDestroy() {
        AppMethodBeat.i(35374);
        super.onDestroy();
        this.zLE.bIf();
        AppMethodBeat.o(35374);
    }

    public void onPause() {
        AppMethodBeat.i(35375);
        super.onPause();
        this.zLG = true;
        AppMethodBeat.o(35375);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(35376);
        if (4 == i) {
            if (!this.zLG) {
                h.pYm.X(10452, this.cKB + "," + this.lRx + "," + (this.zLF == null ? 0 : this.zLF.length) + ",0");
            }
            if (this.zLH) {
                moveTaskToBack(true);
                finish();
                AppMethodBeat.o(35376);
                return true;
            }
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(35376);
        return onKeyDown;
    }

    static boolean asA(String str) {
        AppMethodBeat.i(35377);
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = aw.ZK().fkd.b(t.fkP, null, str);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!t.kH(string)) {
                    arrayList2.add(string);
                }
                ab.d("MicroMsg.VoiceSearchResultUI", "block user ".concat(String.valueOf(string)));
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoiceSearchResultUI", e, "", new Object[0]);
            }
        }
        cursorArr[1] = aw.ZK().fke.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        ab.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            AppMethodBeat.o(35377);
            return true;
        }
        AppMethodBeat.o(35377);
        return false;
    }

    private void V(String[] strArr) {
        AppMethodBeat.i(35378);
        ArrayList arrayList = new ArrayList();
        if (!(strArr == null || this.zLE == null)) {
            for (String str : strArr) {
                if (this.zLE.asz(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.kxK.setVisibility(0);
            if (this.zLt != null) {
                this.kxK.setText(this.zLt);
            } else {
                this.kxK.setText(getString(R.string.dy));
            }
        } else {
            this.kxK.setVisibility(8);
        }
        if (this.zLE != null) {
            b bVar = this.zLE;
            bVar.yDL = (String[]) arrayList.toArray(new String[arrayList.size()]);
            bVar.sfv = null;
            bVar.bIf();
            bVar.ll(false);
        }
        AppMethodBeat.o(35378);
    }

    public final int getLayoutId() {
        return R.layout.b29;
    }

    private void dHz() {
        AppMethodBeat.i(35379);
        LinkedList linkedList = new LinkedList();
        switch (this.showType) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                int YK = r.YK();
                if ((YK & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!(t.Zl() && (YK & 2) == 0)) {
                    linkedList.add("tmessage");
                }
                if ((YK & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((YK & 128) != 0) {
                    linkedList.add("qqsync");
                }
                if ((YK & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((SQLiteGlobal.journalSizeLimit & YK) != 0) {
                    linkedList.add("newsapp");
                }
                if (!((262144 & YK) == 0 && t.Zk())) {
                    linkedList.add("blogapp");
                }
                if ((YK & 65536) != 0) {
                    linkedList.add("masssendapp");
                }
                linkedList.add("voiceinputapp");
                break;
        }
        if (this.zLE != null) {
            this.zLE.fl(linkedList);
        }
        AppMethodBeat.o(35379);
    }
}
