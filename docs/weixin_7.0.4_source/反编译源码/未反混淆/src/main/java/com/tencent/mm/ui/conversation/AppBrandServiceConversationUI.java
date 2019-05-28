package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.conversation.e.g;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.v;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private static final String TAG = "MicroMsg.AppBrandServiceConversationUI";
    private View contentView;

    @Keep
    public static class AppBrandServiceConversationFmUI extends BaseConversationFmUI implements d {
        private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
        private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
        private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
        private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
        private e adapter;
        private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
        private ListView appbrandMessageLV;
        private j contextMenuHelper;
        private ak conversation;
        private TextView emptyTipTv;
        private int fromScene;
        private boolean isDeleteCancel = false;
        private String mAppId;
        private String mSceneId;
        private String superUsername;
        private String talker = "";
        private p tipDialog = null;

        static class a extends e {
            private Paint aFY = new Paint();
            List<String> ewK;
            private String username;
            private c<lo> yTn;
            private HashMap<String, Boolean> zqo;
            private HashMap<String, String> zqp;

            a(Context context, String str, com.tencent.mm.ui.p.a aVar) {
                super(context, aVar);
                AppMethodBeat.i(34000);
                this.username = str;
                this.zqo = new HashMap();
                this.zqp = new HashMap();
                this.ewK = new ArrayList();
                this.yTn = new c<lo>() {
                    {
                        AppMethodBeat.i(33998);
                        this.xxI = lo.class.getName().hashCode();
                        AppMethodBeat.o(33998);
                    }

                    public final /* synthetic */ boolean a(b bVar) {
                        boolean z = false;
                        AppMethodBeat.i(33999);
                        lo loVar = (lo) bVar;
                        if (loVar.cHo.csl != null) {
                            ab.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", loVar.cHo.csl, Integer.valueOf(loVar.cHo.cHp));
                            if ((loVar.cHo.cHp & 2) > 0) {
                                z = true;
                            }
                            a.this.zqo.remove(loVar.cHo.csl);
                            a.this.zqo.put(loVar.cHo.csl, Boolean.valueOf(z));
                            a.this.notifyDataSetChanged();
                        } else {
                            ab.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                        }
                        AppMethodBeat.o(33999);
                        return true;
                    }
                };
                com.tencent.mm.sdk.b.a.xxA.c(this.yTn);
                AppMethodBeat.o(34000);
            }

            public final void KC() {
                AppMethodBeat.i(34001);
                aw.ZK();
                setCursor(com.tencent.mm.model.c.XR().c(t.fkV, this.elZ, this.username));
                if (this.yle != null) {
                    this.yle.apt();
                }
                super.notifyDataSetChanged();
                AppMethodBeat.o(34001);
            }

            /* Access modifiers changed, original: protected|final */
            public final void a(String str, g gVar) {
                boolean z;
                AppMethodBeat.i(34002);
                Boolean bool = (Boolean) this.zqo.get(str);
                if (bool == null) {
                    WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(str);
                    z = zb != null && (zb.field_appOpt & 2) > 0;
                    this.zqo.put(str, bool);
                } else {
                    z = bool.booleanValue();
                }
                if (z) {
                    gVar.yEf.setVisibility(0);
                    gVar.yEf.setImageResource(R.raw.chat_reject_icon);
                } else {
                    gVar.yEf.setVisibility(8);
                }
                CharSequence charSequence = (String) this.zqp.get(str);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = com.tencent.mm.ui.appbrand.b.aqK(com.tencent.mm.ui.appbrand.b.aqJ(str));
                    if (!TextUtils.isEmpty(charSequence)) {
                        this.zqp.put(str, charSequence);
                    }
                }
                LayoutParams layoutParams;
                if (TextUtils.isEmpty(charSequence)) {
                    layoutParams = (LayoutParams) gVar.yEc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.weight = 0.0f;
                    gVar.yEc.setLayoutParams(layoutParams);
                } else {
                    int i;
                    int dimensionPixelOffset;
                    int dimensionPixelOffset2;
                    String str2;
                    float f;
                    float f2;
                    float f3;
                    gVar.zrV.setVisibility(0);
                    gVar.zrV.setText(this.context.getString(R.string.o7, new Object[]{charSequence}));
                    if (this.context.getResources().getDisplayMetrics() != null) {
                        i = this.context.getResources().getDisplayMetrics().widthPixels;
                    } else {
                        i = 0;
                    }
                    if (com.tencent.mm.bz.a.ga(this.context)) {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.lx);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.dimen.f9);
                    } else {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.ly);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.dimen.f_);
                    }
                    int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.dimen.l5);
                    int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(R.dimen.m4);
                    d dVar = (d) this.yDY.get(str);
                    if (dVar == null || dVar.nickName == null) {
                        str2 = "";
                    } else {
                        str2 = dVar.nickName.toString();
                    }
                    if (str2 == null) {
                        f = 0.0f;
                    } else {
                        this.aFY.setTextSize(this.yDV);
                        f = this.aFY.measureText(str2);
                    }
                    float f4 = 48.0f + f;
                    int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(R.dimen.f_);
                    int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(R.dimen.le);
                    ab.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", Integer.valueOf(i), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2));
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
                    layoutParams = (LayoutParams) gVar.yEc.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f3;
                    gVar.yEc.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) gVar.zrV.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f2;
                    gVar.zrV.setLayoutParams(layoutParams);
                }
                com.tencent.mm.pluginsdk.ui.a.b.r(gVar.ejo, str);
                if (!this.ewK.contains(str)) {
                    this.ewK.add(str);
                }
                AppMethodBeat.o(34002);
            }

            public final void detach() {
                AppMethodBeat.i(34003);
                this.zqo = null;
                com.tencent.mm.sdk.b.a.xxA.d(this.yTn);
                AppMethodBeat.o(34003);
            }
        }

        static /* synthetic */ void access$200(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, int i) {
            AppMethodBeat.i(34021);
            appBrandServiceConversationFmUI.setShowView(i);
            AppMethodBeat.o(34021);
        }

        static /* synthetic */ void access$800(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI, String str) {
            AppMethodBeat.i(34022);
            appBrandServiceConversationFmUI.delConversationAndMsg(str);
            AppMethodBeat.o(34022);
        }

        public void onActivityCreated(Bundle bundle) {
            AppMethodBeat.i(34004);
            ab.i(TAG, "onActivityCreated");
            super.onActivityCreated(bundle);
            this.superUsername = getStringExtra("Contact_User");
            if (TextUtils.isEmpty(this.superUsername)) {
                this.superUsername = "appbrandcustomerservicemsg";
            }
            this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
            ab.i(TAG, "fromScene:%d", Integer.valueOf(this.fromScene));
            aw.ZK();
            this.mSceneId = System.currentTimeMillis() + intToString(com.tencent.mm.model.c.QF());
            initView();
            addIconOptionMenu(1, R.raw.app_brand_setting, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33985);
                    Intent intent = new Intent(AppBrandServiceConversationFmUI.this.getContext(), ServiceNotifySettingsUI.class);
                    intent.putExtra("mode", 1);
                    intent.putExtra("scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                    AppBrandServiceConversationFmUI.this.startActivity(intent);
                    AppMethodBeat.o(33985);
                    return true;
                }
            });
            aw.ZK();
            com.tencent.mm.model.c.XR().a(this.adapter);
            cleadAllServiceAppBrandUnreadCount();
            enterConversationReport();
            batchSyncForWxaContact();
            AppMethodBeat.o(34004);
        }

        private void cleadAllServiceAppBrandUnreadCount() {
            AppMethodBeat.i(34005);
            com.tencent.mm.sdk.b.a.xxA.m(new o());
            AppMethodBeat.o(34005);
        }

        public int getLayoutId() {
            return R.layout.azr;
        }

        public String getUserName() {
            return this.superUsername;
        }

        public void onDestroy() {
            AppMethodBeat.i(34006);
            if (aw.RK()) {
                aw.ZK();
                com.tencent.mm.model.c.XR().b(this.adapter);
            }
            batchSyncForWxaContact();
            if (this.adapter != null) {
                this.adapter.onDestroy();
            }
            super.onDestroy();
            AppMethodBeat.o(34006);
        }

        public void onResume() {
            AppMethodBeat.i(34007);
            ab.i(TAG, "on resume");
            if (this.adapter != null) {
                this.adapter.onResume();
            }
            super.onResume();
            AppMethodBeat.o(34007);
        }

        public void onPause() {
            AppMethodBeat.i(34008);
            ab.i(TAG, "on pause");
            aw.ZK();
            com.tencent.mm.model.c.XR().apb(this.superUsername);
            if (this.adapter != null) {
                this.adapter.onPause();
            }
            super.onPause();
            AppMethodBeat.o(34008);
        }

        private void batchSyncForWxaContact() {
            AppMethodBeat.i(34009);
            if (this.adapter == null || this.adapter.getCount() == 0) {
                AppMethodBeat.o(34009);
                return;
            }
            ab.i(TAG, "batchSyncForWxaContact, size:%d", Integer.valueOf(this.adapter.getCount()));
            if (this.adapter instanceof a) {
                List list = ((a) this.adapter).ewK;
                if (list != null && list.size() > 0) {
                    ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).aE(list);
                }
            }
            AppMethodBeat.o(34009);
        }

        private String intToString(int i) {
            AppMethodBeat.i(34010);
            String bigInteger = new BigInteger(Integer.toBinaryString(i), 2).toString();
            AppMethodBeat.o(34010);
            return bigInteger;
        }

        private void enterConversationReport() {
            AppMethodBeat.i(34011);
            String str = "";
            if (this.adapter == null) {
                ab.d(TAG, "adapter is null!");
                AppMethodBeat.o(34011);
                return;
            }
            int i;
            Object obj;
            int i2;
            aw.ZK();
            ak aoZ = com.tencent.mm.model.c.XR().aoZ("appbrandcustomerservicemsg");
            if (aoZ == null || bo.isNullOrNil(aoZ.field_username)) {
                i = 0;
            } else {
                i = aoZ.field_unReadCount;
            }
            aoZ = (ak) this.adapter.getItem(0);
            if (aoZ == null || bo.isNullOrNil(aoZ.field_username)) {
                String obj2 = str;
            } else {
                String nullAsNil = bo.nullAsNil(aoZ.field_content);
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(aoZ.field_username);
                this.mAppId = zb == null ? null : zb.field_appId;
                obj2 = nullAsNil;
            }
            if (i > 0) {
                int count = this.adapter.getCount();
                int i3 = 0;
                i2 = 0;
                while (i3 < count) {
                    int i4;
                    aoZ = (ak) this.adapter.getItem(i3);
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
            ab.d(TAG, "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", Integer.valueOf(13797), this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, obj2);
            h.pYm.e(13797, this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, Long.valueOf(bo.anT()), Integer.valueOf(0), obj2);
            AppMethodBeat.o(34011);
        }

        public void customerMsgOperateReport(int i) {
            AppMethodBeat.i(34012);
            ab.d(TAG, "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), this.mAppId, this.mSceneId);
            h.pYm.e(13798, Integer.valueOf(i), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bo.anT()));
            AppMethodBeat.o(34012);
        }

        public void entryCustomerMsgDialogReport(String str, int i) {
            AppMethodBeat.i(34013);
            aw.ZK();
            ak aoZ = com.tencent.mm.model.c.XR().aoZ(str);
            if (aoZ == null) {
                ab.e(TAG, "cvs:%s is null, error", str);
                AppMethodBeat.o(34013);
                return;
            }
            int i2 = aoZ.field_unReadCount;
            String nullAsNil = bo.nullAsNil(this.mSceneId);
            ab.d(TAG, "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil);
            h.pYm.e(13799, this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil, Long.valueOf(bo.anT()));
            AppMethodBeat.o(34013);
        }

        /* Access modifiers changed, original: protected */
        public void initView() {
            AppMethodBeat.i(34014);
            setMMTitle(getString(R.string.hj));
            this.appbrandMessageLV = (ListView) findViewById(R.id.bi5);
            this.emptyTipTv = (TextView) findViewById(R.id.a74);
            this.emptyTipTv.setText(R.string.i6);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(33990);
                    AppBrandServiceConversationFmUI.this.finish();
                    AppMethodBeat.o(33990);
                    return true;
                }
            });
            this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(thisActivity());
            this.adapter = new a(thisActivity(), this.superUsername, new com.tencent.mm.ui.p.a() {
                public final void apt() {
                    AppMethodBeat.i(33991);
                    AppBrandServiceConversationFmUI.access$200(AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this.adapter.getCount());
                    AppMethodBeat.o(33991);
                }
            });
            this.adapter.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(33992);
                    int positionForView = AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                    AppMethodBeat.o(33992);
                    return positionForView;
                }
            });
            this.adapter.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(33993);
                    AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(33993);
                }
            });
            this.appbrandMessageLV.setAdapter(this.adapter);
            this.contextMenuHelper = new j(thisActivity());
            this.appbrandMessageLV.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33994);
                    AppBrandServiceConversationFmUI.this.conversation = (ak) AppBrandServiceConversationFmUI.this.adapter.getItem(i);
                    ak access$400 = AppBrandServiceConversationFmUI.this.conversation;
                    if (access$400 == null) {
                        ab.e(AppBrandServiceConversationFmUI.TAG, "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(AppBrandServiceConversationFmUI.this.adapter.getCount()));
                        AppBrandServiceConversationFmUI.this.adapter.notifyDataSetChanged();
                        AppMethodBeat.o(33994);
                        return;
                    }
                    AppBrandServiceConversationFmUI.this.talker = access$400.field_username;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("finish_direct", false);
                    bundle.putBoolean("key_need_send_video", false);
                    bundle.putString("key_scene_id", AppBrandServiceConversationFmUI.this.mSceneId);
                    bundle.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationFmUI.this.fromScene);
                    AppBrandServiceConversationFmUI.this.ui.startChatting(access$400.field_username, bundle, true);
                    AppBrandServiceConversationFmUI.this.entryCustomerMsgDialogReport(access$400.field_username, AppBrandServiceConversationFmUI.this.fromScene);
                    AppMethodBeat.o(33994);
                }
            });
            this.appbrandMessageLV.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(33995);
                    AppBrandServiceConversationFmUI.this.conversation = (ak) AppBrandServiceConversationFmUI.this.adapter.getItem(i);
                    AppBrandServiceConversationFmUI.this.talker = AppBrandServiceConversationFmUI.this.conversation.field_username;
                    AppBrandServiceConversationFmUI.this.contextMenuHelper.a(view, i, j, AppBrandServiceConversationFmUI.this, AppBrandServiceConversationFmUI.this);
                    AppMethodBeat.o(33995);
                    return true;
                }
            });
            this.adapter.setGetViewPositionCallback(new MMSlideDelView.c() {
                public final int cZ(View view) {
                    AppMethodBeat.i(33996);
                    int positionForView = AppBrandServiceConversationFmUI.this.appbrandMessageLV.getPositionForView(view);
                    AppMethodBeat.o(33996);
                    return positionForView;
                }
            });
            this.adapter.setPerformItemClickListener(new MMSlideDelView.g() {
                public final void q(View view, int i, int i2) {
                    AppMethodBeat.i(33997);
                    AppBrandServiceConversationFmUI.this.appbrandMessageLV.performItemClick(view, i, (long) i2);
                    AppMethodBeat.o(33997);
                }
            });
            this.adapter.a(new f() {
                public final void bN(Object obj) {
                    AppMethodBeat.i(33986);
                    if (obj == null) {
                        ab.e(AppBrandServiceConversationFmUI.TAG, "onItemDel object null");
                        AppMethodBeat.o(33986);
                        return;
                    }
                    AppBrandServiceConversationFmUI.access$800(AppBrandServiceConversationFmUI.this, obj.toString());
                    AppMethodBeat.o(33986);
                }
            });
            AppMethodBeat.o(34014);
        }

        public void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(34015);
            super.onActivityResult(i, i2, intent);
            if (!(this.talker == null || this.talker.isEmpty())) {
                this.talker = "";
            }
            if (i2 != -1) {
                AppMethodBeat.o(34015);
            } else {
                AppMethodBeat.o(34015);
            }
        }

        private void setShowView(int i) {
            AppMethodBeat.i(34016);
            if (i <= 0) {
                this.emptyTipTv.setVisibility(0);
                this.appbrandMessageLV.setVisibility(8);
                AppMethodBeat.o(34016);
                return;
            }
            this.emptyTipTv.setVisibility(8);
            this.appbrandMessageLV.setVisibility(0);
            AppMethodBeat.o(34016);
        }

        private void delConversationAndMsg(String str) {
            AppMethodBeat.i(34017);
            if (bo.isNullOrNil(str)) {
                ab.e(TAG, "Delete Conversation and messages fail because username is null or nil.");
                AppMethodBeat.o(34017);
                return;
            }
            asyncDelMsg(str);
            aw.ZK();
            com.tencent.mm.model.c.XR().aoX(str);
            AppMethodBeat.o(34017);
        }

        private void asyncDelMsg(String str) {
            AppMethodBeat.i(34018);
            ab.i(TAG, "async del msg talker:%s", str);
            aw.ZK();
            bi Ra = com.tencent.mm.model.c.XO().Ra(str);
            vo voVar = new vo();
            voVar.wcB = new bts().alV(bo.nullAsNil(str));
            voVar.ptF = Ra.field_msgSvrId;
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(8, voVar));
            this.isDeleteCancel = false;
            Context thisActivity = thisActivity();
            getString(R.string.tz);
            final p b = com.tencent.mm.ui.base.h.b(thisActivity, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(33987);
                    AppBrandServiceConversationFmUI.this.isDeleteCancel = true;
                    AppMethodBeat.o(33987);
                }
            });
            customerMsgOperateReport(5);
            bf.a(str, new com.tencent.mm.model.bf.a() {
                public final boolean JU() {
                    AppMethodBeat.i(33988);
                    boolean access$900 = AppBrandServiceConversationFmUI.this.isDeleteCancel;
                    AppMethodBeat.o(33988);
                    return access$900;
                }

                public final void JV() {
                    AppMethodBeat.i(33989);
                    if (b != null) {
                        b.dismiss();
                    }
                    AppMethodBeat.o(33989);
                }
            });
            AppMethodBeat.o(34018);
        }

        public void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(34019);
            aw.ZK();
            ad aoO = com.tencent.mm.model.c.XM().aoO(this.talker);
            if (aoO == null || ((int) aoO.ewQ) == 0) {
                ab.e(TAG, "changed biz stick status failed, contact is null, talker = " + this.talker);
                AppMethodBeat.o(34019);
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.yrk = this.mSceneId;
                    this.appBrandServiceActionSheet.jnK = true;
                    this.appBrandServiceActionSheet.show(3);
                    AppMethodBeat.o(34019);
                    return;
                case 2:
                    this.appBrandServiceActionSheet.username = this.talker;
                    this.appBrandServiceActionSheet.scene = this.fromScene;
                    this.appBrandServiceActionSheet.yrk = this.mSceneId;
                    this.appBrandServiceActionSheet.jnK = true;
                    this.appBrandServiceActionSheet.show(4);
                    AppMethodBeat.o(34019);
                    return;
                case 3:
                    delConversationAndMsg(this.talker);
                    break;
            }
            AppMethodBeat.o(34019);
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(34020);
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(this.talker);
            int i = (zb == null || (zb.field_appOpt & 2) <= 0) ? 0 : 1;
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.string.ku);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.string.kv);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.string.b59);
            AppMethodBeat.o(34020);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(34023);
        super.onCreate(bundle);
        this.contentView = v.hu(this).inflate(R.layout.hj, null);
        setContentView(this.contentView);
        this.conversationFm = new AppBrandServiceConversationFmUI();
        getSupportFragmentManager().beginTransaction().a((int) R.id.a9e, this.conversationFm).commit();
        com.tencent.mm.pluginsdk.f.a(this, this.contentView);
        AppMethodBeat.o(34023);
    }

    public final void finish() {
        AppMethodBeat.i(34024);
        super.finish();
        AppMethodBeat.o(34024);
    }

    /* Access modifiers changed, original: protected|final */
    public final ChattingUIFragment getChattingUIFragment() {
        AppMethodBeat.i(34025);
        AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI();
        AppMethodBeat.o(34025);
        return appBrandServiceChattingFmUI;
    }
}
