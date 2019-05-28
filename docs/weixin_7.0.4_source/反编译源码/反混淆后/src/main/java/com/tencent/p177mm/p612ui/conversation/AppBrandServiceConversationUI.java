package com.tencent.p177mm.p612ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32603o;
import com.tencent.p177mm.p230g.p231a.C37758lo;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.ServiceNotifySettingsUI;
import com.tencent.p177mm.p612ui.appbrand.C40661a;
import com.tencent.p177mm.p612ui.appbrand.C40663b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.p177mm.p612ui.chatting.ChattingUIFragment;
import com.tencent.p177mm.p612ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.p177mm.p612ui.conversation.C36282e.C36279d;
import com.tencent.p177mm.p612ui.conversation.C36282e.C5486g;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.C40580vo;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
/* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI */
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
    private View contentView;

    @Keep
    /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI */
    public static class AppBrandServiceConversationFmUI extends BaseConversationFmUI implements C5279d {
        private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
        private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
        private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
        private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
        private C36282e adapter;
        private C40661a appBrandServiceActionSheet;
        private ListView appbrandMessageLV;
        private C46696j contextMenuHelper;
        private C7617ak conversation;
        private TextView emptyTipTv;
        private int fromScene;
        private boolean isDeleteCancel = false;
        private String mAppId;
        private String mSceneId;
        private String superUsername;
        private String talker = "";
        private C44275p tipDialog = null;

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$3 */
        class C158313 implements OnCancelListener {
            C158313() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(33987);
                AppBrandServiceConversationFmUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(33987);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$11 */
        class C1702011 implements C15521c {
            C1702011() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(33996);
                int positionForView = AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                AppMethodBeat.m2505o(33996);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1 */
        class C170211 implements OnMenuItemClickListener {
            C170211() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(33985);
                Intent intent = new Intent(AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
                intent.putExtra("mode", 1);
                intent.putExtra("scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                AppBrandServiceConversationFmUI.this.startActivity(intent);
                AppMethodBeat.m2505o(33985);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10 */
        class C1702210 implements OnItemLongClickListener {
            C1702210() {
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(33995);
                AppBrandServiceConversationFmUI.this.conversation = (C7617ak) AppBrandServiceConversationFmUI.this.adapter.getItem(i);
                AppBrandServiceConversationFmUI.this.talker = AppBrandServiceConversationFmUI.this.conversation.field_username;
                AppBrandServiceConversationFmUI.this.contextMenuHelper.mo75004a(view, i, j, AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this);
                AppMethodBeat.m2505o(33995);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2 */
        class C170232 implements C23599f {
            C170232() {
            }

            /* renamed from: bN */
            public final void mo11067bN(Object obj) {
                AppMethodBeat.m2504i(33986);
                if (obj == null) {
                    C4990ab.m7412e(AppBrandServiceConversationFmUI.TAG, "onItemDel object null");
                    AppMethodBeat.m2505o(33986);
                    return;
                }
                AppBrandServiceConversationFmUI.access$800(AppBrandServiceConversationFmUI.this, obj.toString());
                AppMethodBeat.m2505o(33986);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$5 */
        class C170255 implements OnMenuItemClickListener {
            C170255() {
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(33990);
                AppBrandServiceConversationFmUI.this.finish();
                AppMethodBeat.m2505o(33990);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$6 */
        class C170266 implements C30723a {
            C170266() {
            }

            public final void apt() {
                AppMethodBeat.m2504i(33991);
                AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this.adapter.getCount());
                AppMethodBeat.m2505o(33991);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$8 */
        class C170278 implements C23600g {
            C170278() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(33993);
                AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(33993);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a */
        static class C17028a extends C36282e {
            private Paint aFY = new Paint();
            List<String> ewK;
            private String username;
            private C4884c<C37758lo> yTn;
            private HashMap<String, Boolean> zqo;
            private HashMap<String, String> zqp;

            /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$a$1 */
            class C158321 extends C4884c<C37758lo> {
                C158321() {
                    AppMethodBeat.m2504i(33998);
                    this.xxI = C37758lo.class.getName().hashCode();
                    AppMethodBeat.m2505o(33998);
                }

                /* renamed from: a */
                public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                    boolean z = false;
                    AppMethodBeat.m2504i(33999);
                    C37758lo c37758lo = (C37758lo) c4883b;
                    if (c37758lo.cHo.csl != null) {
                        C4990ab.m7411d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", c37758lo.cHo.csl, Integer.valueOf(c37758lo.cHo.cHp));
                        if ((c37758lo.cHo.cHp & 2) > 0) {
                            z = true;
                        }
                        C17028a.this.zqo.remove(c37758lo.cHo.csl);
                        C17028a.this.zqo.put(c37758lo.cHo.csl, Boolean.valueOf(z));
                        C17028a.this.notifyDataSetChanged();
                    } else {
                        C4990ab.m7412e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                    }
                    AppMethodBeat.m2505o(33999);
                    return true;
                }
            }

            C17028a(Context context, String str, C30723a c30723a) {
                super(context, c30723a);
                AppMethodBeat.m2504i(34000);
                this.username = str;
                this.zqo = new HashMap();
                this.zqp = new HashMap();
                this.ewK = new ArrayList();
                this.yTn = new C158321();
                C4879a.xxA.mo10052c(this.yTn);
                AppMethodBeat.m2505o(34000);
            }

            /* renamed from: KC */
            public final void mo6869KC() {
                AppMethodBeat.m2504i(34001);
                C9638aw.m17190ZK();
                setCursor(C18628c.m29083XR().mo15804c(C1855t.fkV, this.elZ, this.username));
                if (this.yle != null) {
                    this.yle.apt();
                }
                super.notifyDataSetChanged();
                AppMethodBeat.m2505o(34001);
            }

            /* Access modifiers changed, original: protected|final */
            /* renamed from: a */
            public final void mo31098a(String str, C5486g c5486g) {
                boolean z;
                AppMethodBeat.m2504i(34002);
                Boolean bool = (Boolean) this.zqo.get(str);
                if (bool == null) {
                    WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(str);
                    z = zb != null && (zb.field_appOpt & 2) > 0;
                    this.zqo.put(str, bool);
                } else {
                    z = bool.booleanValue();
                }
                if (z) {
                    c5486g.yEf.setVisibility(0);
                    c5486g.yEf.setImageResource(C1318a.chat_reject_icon);
                } else {
                    c5486g.yEf.setVisibility(8);
                }
                CharSequence charSequence = (String) this.zqp.get(str);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = C40663b.aqK(C40663b.aqJ(str));
                    if (!TextUtils.isEmpty(charSequence)) {
                        this.zqp.put(str, charSequence);
                    }
                }
                LayoutParams layoutParams;
                if (TextUtils.isEmpty(charSequence)) {
                    layoutParams = (LayoutParams) c5486g.yEc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.weight = 0.0f;
                    c5486g.yEc.setLayoutParams(layoutParams);
                } else {
                    int i;
                    int dimensionPixelOffset;
                    int dimensionPixelOffset2;
                    String str2;
                    float f;
                    float f2;
                    float f3;
                    c5486g.zrV.setVisibility(0);
                    c5486g.zrV.setText(this.context.getString(C25738R.string.f9062o7, new Object[]{charSequence}));
                    if (this.context.getResources().getDisplayMetrics() != null) {
                        i = this.context.getResources().getDisplayMetrics().widthPixels;
                    } else {
                        i = 0;
                    }
                    if (C1338a.m2865ga(this.context)) {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9973lx);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9773f9);
                    } else {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9974ly);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9774f_);
                    }
                    int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
                    int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
                    C36279d c36279d = (C36279d) this.yDY.get(str);
                    if (c36279d == null || c36279d.nickName == null) {
                        str2 = "";
                    } else {
                        str2 = c36279d.nickName.toString();
                    }
                    if (str2 == null) {
                        f = 0.0f;
                    } else {
                        this.aFY.setTextSize(this.yDV);
                        f = this.aFY.measureText(str2);
                    }
                    float f4 = 48.0f + f;
                    int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9774f_);
                    int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(C25738R.dimen.f9958le);
                    C4990ab.m7417i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", Integer.valueOf(i), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2));
                    f = 0.0f;
                    if (i > 0) {
                        f = (float) ((((i - dimensionPixelOffset) - dimensionPixelOffset3) - dimensionPixelOffset4) - dimensionPixelOffset2);
                    }
                    if (f4 > f || f4 >= f || f <= 0.0f) {
                        f2 = 0.4f;
                        f3 = 0.6f;
                    } else {
                        f = Math.min(f4 / f, (((f - ((float) dimensionPixelOffset5)) - ((float) dimensionPixelOffset6)) - 48.0f) / f);
                        f2 = 1.0f - f;
                        f3 = f;
                    }
                    layoutParams = (LayoutParams) c5486g.yEc.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f3;
                    c5486g.yEc.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) c5486g.zrV.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f2;
                    c5486g.zrV.setLayoutParams(layoutParams);
                }
                C40460b.m69437r(c5486g.ejo, str);
                if (!this.ewK.contains(str)) {
                    this.ewK.add(str);
                }
                AppMethodBeat.m2505o(34002);
            }

            public final void detach() {
                AppMethodBeat.m2504i(34003);
                this.zqo = null;
                C4879a.xxA.mo10053d(this.yTn);
                AppMethodBeat.m2505o(34003);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$12 */
        class C1702912 implements C23600g {
            C1702912() {
            }

            /* renamed from: q */
            public final void mo11108q(View view, int i, int i2) {
                AppMethodBeat.m2504i(33997);
                AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i, (long) i2);
                AppMethodBeat.m2505o(33997);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$7 */
        class C170307 implements C15521c {
            C170307() {
            }

            /* renamed from: cZ */
            public final int mo8831cZ(View view) {
                AppMethodBeat.m2504i(33992);
                int positionForView = AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                AppMethodBeat.m2505o(33992);
                return positionForView;
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$9 */
        class C170319 implements OnItemClickListener {
            C170319() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(33994);
                AppBrandServiceConversationFmUI.this.conversation = (C7617ak) AppBrandServiceConversationFmUI.this.adapter.getItem(i);
                C7617ak access$400 = AppBrandServiceConversationFmUI.this.conversation;
                if (access$400 == null) {
                    C4990ab.m7413e(AppBrandServiceConversationFmUI.TAG, "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(AppBrandServiceConversationFmUI.this.adapter.getCount()));
                    AppBrandServiceConversationFmUI.this.adapter.notifyDataSetChanged();
                    AppMethodBeat.m2505o(33994);
                    return;
                }
                AppBrandServiceConversationFmUI.this.talker = access$400.field_username;
                Bundle bundle = new Bundle();
                bundle.putBoolean("finish_direct", false);
                bundle.putBoolean("key_need_send_video", false);
                bundle.putString("key_scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                bundle.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationFmUI.this.fromScene);
                AppBrandServiceConversationFmUI.this.f2991ui.startChatting(access$400.field_username, bundle, true);
                AppBrandServiceConversationFmUI.this.entryCustomerMsgDialogReport(access$400.field_username, AppBrandServiceConversationFmUI.this.fromScene);
                AppMethodBeat.m2505o(33994);
            }
        }

        static /* synthetic */ void access$200(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, int i) {
            AppMethodBeat.m2504i(34021);
            appBrandServiceConversationFmUI.setShowView(i);
            AppMethodBeat.m2505o(34021);
        }

        static /* synthetic */ void access$800(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, String str) {
            AppMethodBeat.m2504i(34022);
            appBrandServiceConversationFmUI.delConversationAndMsg(str);
            AppMethodBeat.m2505o(34022);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.m2504i(34004);
            C4990ab.m7416i(TAG, "onActivityCreated");
            super.onActivityCreated(bundle);
            this.superUsername = getStringExtra("Contact_User");
            if (TextUtils.isEmpty(this.superUsername)) {
                this.superUsername = "appbrandcustomerservicemsg";
            }
            this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
            C4990ab.m7417i(TAG, "fromScene:%d", Integer.valueOf(this.fromScene));
            C9638aw.m17190ZK();
            this.mSceneId = System.currentTimeMillis() + intToString(C18628c.m29064QF());
            initView();
            addIconOptionMenu(1, C1318a.app_brand_setting, new C170211());
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(this.adapter);
            cleadAllServiceAppBrandUnreadCount();
            enterConversationReport();
            batchSyncForWxaContact();
            AppMethodBeat.m2505o(34004);
        }

        private void cleadAllServiceAppBrandUnreadCount() {
            AppMethodBeat.m2504i(34005);
            C4879a.xxA.mo10055m(new C32603o());
            AppMethodBeat.m2505o(34005);
        }

        public int getLayoutId() {
            return 2130970930;
        }

        public String getUserName() {
            return this.superUsername;
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(34006);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo10121b(this.adapter);
            }
            batchSyncForWxaContact();
            if (this.adapter != null) {
                this.adapter.onDestroy();
            }
            super.onDestroy();
            AppMethodBeat.m2505o(34006);
        }

        public void onResume() {
            AppMethodBeat.m2504i(34007);
            C4990ab.m7416i(TAG, "on resume");
            if (this.adapter != null) {
                this.adapter.onResume();
            }
            super.onResume();
            AppMethodBeat.m2505o(34007);
        }

        public void onPause() {
            AppMethodBeat.m2504i(34008);
            C4990ab.m7416i(TAG, "on pause");
            C9638aw.m17190ZK();
            C18628c.m29083XR().apb(this.superUsername);
            if (this.adapter != null) {
                this.adapter.onPause();
            }
            super.onPause();
            AppMethodBeat.m2505o(34008);
        }

        private void batchSyncForWxaContact() {
            AppMethodBeat.m2504i(34009);
            if (this.adapter == null || this.adapter.getCount() == 0) {
                AppMethodBeat.m2505o(34009);
                return;
            }
            C4990ab.m7417i(TAG, "batchSyncForWxaContact, size:%d", Integer.valueOf(this.adapter.getCount()));
            if (this.adapter instanceof C17028a) {
                List list = ((C17028a) this.adapter).ewK;
                if (list != null && list.size() > 0) {
                    ((C42686d) C1720g.m3528K(C42686d.class)).mo44616aE(list);
                }
            }
            AppMethodBeat.m2505o(34009);
        }

        private String intToString(int i) {
            AppMethodBeat.m2504i(34010);
            String bigInteger = new BigInteger(Integer.toBinaryString(i), 2).toString();
            AppMethodBeat.m2505o(34010);
            return bigInteger;
        }

        private void enterConversationReport() {
            AppMethodBeat.m2504i(34011);
            String str = "";
            if (this.adapter == null) {
                C4990ab.m7410d(TAG, "adapter is null!");
                AppMethodBeat.m2505o(34011);
                return;
            }
            int i;
            Object obj;
            int i2;
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ("appbrandcustomerservicemsg");
            if (aoZ == null || C5046bo.isNullOrNil(aoZ.field_username)) {
                i = 0;
            } else {
                i = aoZ.field_unReadCount;
            }
            aoZ = (C7617ak) this.adapter.getItem(0);
            if (aoZ == null || C5046bo.isNullOrNil(aoZ.field_username)) {
                String obj2 = str;
            } else {
                String nullAsNil = C5046bo.nullAsNil(aoZ.field_content);
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(aoZ.field_username);
                this.mAppId = zb == null ? null : zb.field_appId;
                obj2 = nullAsNil;
            }
            if (i > 0) {
                int count = this.adapter.getCount();
                int i3 = 0;
                i2 = 0;
                while (i3 < count) {
                    int i4;
                    aoZ = (C7617ak) this.adapter.getItem(i3);
                    if (aoZ.field_unReadMuteCount + aoZ.field_unReadCount > 0) {
                        i4 = i2 + 1;
                    } else {
                        i4 = i2;
                    }
                    i3++;
                    i2 = i4;
                }
            } else {
                i2 = 0;
            }
            C4990ab.m7411d(TAG, "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", Integer.valueOf(13797), this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, obj2);
            C7060h.pYm.mo8381e(13797, this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, Long.valueOf(C5046bo.anT()), Integer.valueOf(0), obj2);
            AppMethodBeat.m2505o(34011);
        }

        public void customerMsgOperateReport(int i) {
            AppMethodBeat.m2504i(34012);
            C4990ab.m7411d(TAG, "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), this.mAppId, this.mSceneId);
            C7060h.pYm.mo8381e(13798, Integer.valueOf(i), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(C5046bo.anT()));
            AppMethodBeat.m2505o(34012);
        }

        public void entryCustomerMsgDialogReport(String str, int i) {
            AppMethodBeat.m2504i(34013);
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(str);
            if (aoZ == null) {
                C4990ab.m7413e(TAG, "cvs:%s is null, error", str);
                AppMethodBeat.m2505o(34013);
                return;
            }
            int i2 = aoZ.field_unReadCount;
            String nullAsNil = C5046bo.nullAsNil(this.mSceneId);
            C4990ab.m7411d(TAG, "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil);
            C7060h.pYm.mo8381e(13799, this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil, Long.valueOf(C5046bo.anT()));
            AppMethodBeat.m2505o(34013);
        }

        /* Access modifiers changed, original: protected */
        public void initView() {
            AppMethodBeat.m2504i(34014);
            setMMTitle(getString(C25738R.string.f8866hj));
            this.appbrandMessageLV = (ListView) findViewById(2131823620);
            this.emptyTipTv = (TextView) findViewById(2131821807);
            this.emptyTipTv.setText(C25738R.string.f8885i6);
            setBackBtn(new C170255());
            this.appBrandServiceActionSheet = new C40661a(thisActivity());
            this.adapter = new C17028a(thisActivity(), this.superUsername, new C170266());
            this.adapter.setGetViewPositionCallback(new C170307());
            this.adapter.setPerformItemClickListener(new C170278());
            this.appbrandMessageLV.setAdapter(this.adapter);
            this.contextMenuHelper = new C46696j(thisActivity());
            this.appbrandMessageLV.setOnItemClickListener(new C170319());
            this.appbrandMessageLV.setOnItemLongClickListener(new C1702210());
            this.adapter.setGetViewPositionCallback(new C1702011());
            this.adapter.setPerformItemClickListener(new C1702912());
            this.adapter.mo57142a(new C170232());
            AppMethodBeat.m2505o(34014);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(34015);
            super.onActivityResult(i, i2, intent);
            if (!(this.talker == null || this.talker.isEmpty())) {
                this.talker = "";
            }
            if (i2 != -1) {
                AppMethodBeat.m2505o(34015);
            } else {
                AppMethodBeat.m2505o(34015);
            }
        }

        private void setShowView(int i) {
            AppMethodBeat.m2504i(34016);
            if (i <= 0) {
                this.emptyTipTv.setVisibility(0);
                this.appbrandMessageLV.setVisibility(8);
                AppMethodBeat.m2505o(34016);
                return;
            }
            this.emptyTipTv.setVisibility(8);
            this.appbrandMessageLV.setVisibility(0);
            AppMethodBeat.m2505o(34016);
        }

        private void delConversationAndMsg(String str) {
            AppMethodBeat.m2504i(34017);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e(TAG, "Delete Conversation and messages fail because username is null or nil.");
                AppMethodBeat.m2505o(34017);
                return;
            }
            asyncDelMsg(str);
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoX(str);
            AppMethodBeat.m2505o(34017);
        }

        private void asyncDelMsg(String str) {
            AppMethodBeat.m2504i(34018);
            C4990ab.m7417i(TAG, "async del msg talker:%s", str);
            C9638aw.m17190ZK();
            C7620bi Ra = C18628c.m29080XO().mo15247Ra(str);
            C40580vo c40580vo = new C40580vo();
            c40580vo.wcB = new bts().alV(C5046bo.nullAsNil(str));
            c40580vo.ptF = Ra.field_msgSvrId;
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C3465a(8, c40580vo));
            this.isDeleteCancel = false;
            Context thisActivity = thisActivity();
            getString(C25738R.string.f9238tz);
            final C44275p b = C30379h.m48458b(thisActivity, getString(C25738R.string.f9260un), true, new C158313());
            customerMsgOperateReport(5);
            C1829bf.m3741a(str, new C1827a() {
                /* renamed from: JU */
                public final boolean mo5405JU() {
                    AppMethodBeat.m2504i(33988);
                    boolean access$900 = AppBrandServiceConversationFmUI.this.isDeleteCancel;
                    AppMethodBeat.m2505o(33988);
                    return access$900;
                }

                /* renamed from: JV */
                public final void mo5406JV() {
                    AppMethodBeat.m2504i(33989);
                    if (b != null) {
                        b.dismiss();
                    }
                    AppMethodBeat.m2505o(33989);
                }
            });
            AppMethodBeat.m2505o(34018);
        }

        public void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(34019);
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.talker);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                C4990ab.m7412e(TAG, "changed biz stick status failed, contact is null, talker = " + this.talker);
                AppMethodBeat.m2505o(34019);
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.yrk = this.mSceneId;
                    this.appBrandServiceActionSheet.jnK = true;
                    this.appBrandServiceActionSheet.show(3);
                    AppMethodBeat.m2505o(34019);
                    return;
                case 2:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.yrk = this.mSceneId;
                    this.appBrandServiceActionSheet.jnK = true;
                    this.appBrandServiceActionSheet.show(4);
                    AppMethodBeat.m2505o(34019);
                    return;
                case 3:
                    delConversationAndMsg(this.talker);
                    break;
            }
            AppMethodBeat.m2505o(34019);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(34020);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(this.talker);
            int i = (zb == null || (zb.field_appOpt & 2) <= 0) ? 0 : 1;
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, C25738R.string.f8960ku);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, C25738R.string.f8961kv);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, C25738R.string.b59);
            AppMethodBeat.m2505o(34020);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34023);
        super.onCreate(bundle);
        this.contentView = C5616v.m8409hu(this).inflate(2130968881, null);
        setContentView(this.contentView);
        this.conversationFm = new AppBrandServiceConversationFmUI();
        getSupportFragmentManager().beginTransaction().mo552a(2131821892, this.conversationFm).commit();
        C30036f.m47539a(this, this.contentView);
        AppMethodBeat.m2505o(34023);
    }

    public final void finish() {
        AppMethodBeat.m2504i(34024);
        super.finish();
        AppMethodBeat.m2505o(34024);
    }

    /* Access modifiers changed, original: protected|final */
    public final ChattingUIFragment getChattingUIFragment() {
        AppMethodBeat.m2504i(34025);
        AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI();
        AppMethodBeat.m2505o(34025);
        return appBrandServiceChattingFmUI;
    }
}
