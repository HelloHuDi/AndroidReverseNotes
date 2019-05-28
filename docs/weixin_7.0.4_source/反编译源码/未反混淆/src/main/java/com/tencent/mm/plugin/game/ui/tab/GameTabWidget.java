package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameTabWidget extends LinearLayout {
    public static int nnp = 0;
    private Activity mActivity;
    private a nnq;

    public static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(112274);
            Bundle bundle = (Bundle) obj;
            if (cVar != null) {
                cVar.ao(bundle);
            }
            AppMethodBeat.o(112274);
        }
    }

    public GameTabWidget(Context context) {
        super(context);
        AppMethodBeat.i(112275);
        cA(context);
        AppMethodBeat.o(112275);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112276);
        cA(context);
        AppMethodBeat.o(112276);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112277);
        cA(context);
        AppMethodBeat.o(112277);
    }

    private void cA(Context context) {
        AppMethodBeat.i(112278);
        this.mActivity = (Activity) context;
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(R.color.qa);
        setOrientation(0);
        AppMethodBeat.o(112278);
    }

    public void setAdapter(a aVar) {
        AppMethodBeat.i(112279);
        this.nnq = aVar;
        aVar.registerDataSetObserver(new DataSetObserver() {
            public final void onInvalidated() {
                AppMethodBeat.i(112271);
                GameTabWidget.a(GameTabWidget.this);
                AppMethodBeat.o(112271);
            }

            public final void onChanged() {
                AppMethodBeat.i(112272);
                GameTabWidget.a(GameTabWidget.this);
                AppMethodBeat.o(112272);
            }
        });
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(112279);
    }

    public static void a(Activity activity, TabItem tabItem, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(112280);
        if (activity == null || tabItem == null) {
            AppMethodBeat.o(112280);
        } else if (com.tencent.mm.plugin.game.f.c.ay(activity, tabItem.jumpUrl)) {
            AppMethodBeat.o(112280);
        } else {
            String stringExtra = activity.getIntent().getStringExtra("tab_key");
            if (bo.nullAsNil(tabItem.mYp).equals(stringExtra)) {
                AppMethodBeat.o(112280);
                return;
            }
            boolean z4;
            boolean z5;
            ab.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", activity.getClass().getSimpleName(), tabItem.mYw, Boolean.valueOf(z));
            Intent intent = new Intent();
            intent.setClassName(activity, tabItem.mYw);
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                intent.putExtras(extras);
            } else {
                extras = new Bundle();
            }
            Bundle bundle = new Bundle();
            bundle.putString("tab_key", tabItem.mYp);
            GameTabData gameTabData = (GameTabData) extras.getParcelable("tab_data");
            if (gameTabData != null) {
                TabItem tabItem2 = (TabItem) gameTabData.mYm.get(bo.nullAsNil(stringExtra));
                if (tabItem2 != null) {
                    tabItem2.mYx = true;
                }
                tabItem2 = (TabItem) gameTabData.mYm.get(tabItem.mYp);
                if (tabItem2 != null) {
                    z4 = tabItem2.mYx;
                } else {
                    z4 = false;
                }
                bundle.putParcelable("tab_data", gameTabData);
                z5 = z4;
            } else {
                z5 = false;
            }
            if (!z3) {
                b.a(activity, 18, tabItem.cKG, tabItem.mYy, 2, null, activity.getIntent().getIntExtra("game_report_from_scene", 0), com.tencent.mm.plugin.game.e.a.kY(tabItem.mVB));
            }
            if (!tabItem.mYr) {
                bundle.putString("rawUrl", tabItem.jumpUrl);
                bundle.putBoolean("KRightBtn", true);
                bundle.putBoolean("isWebwx", true);
                bundle.putBoolean("show_bottom", false);
                bundle.putString("title", activity.getString(R.string.c8c));
                bundle.putBoolean("forceHideShare", true);
                bundle.putBoolean("disable_swipe_back", true);
                bundle.putBoolean("show_native_web_view", true);
                bundle.putBoolean("disable_progress_bar", true);
                bundle.putBoolean("disable_bounce_scroll", true);
                bundle.putInt("screen_orientation", 1);
                bundle.putString("KPublisherId", "game_center_entrance");
                bundle.putInt("geta8key_scene", 32);
                if (!(gameTabData == null || gameTabData.mYn == null)) {
                    bundle.putString("status_bar_style", gameTabData.mYn.mYo);
                    bundle.putInt("customize_status_bar_color", gameTabData.mYn.color);
                }
                bundle.putBoolean("game_check_float", z3);
                String string = bundle.getString("rawUrl");
                if (!bo.isNullOrNil(string)) {
                    if (z3) {
                        z4 = intent.getBooleanExtra("from_find_more_friend", false);
                        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
                        if (z4) {
                            ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                            n bEo = q.bEo();
                            if (bEo == null) {
                                ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCX();
                                bEo = q.bEs();
                            }
                            bundle.putString("rawUrl", l.a(string, bEo));
                            if (bEo != null) {
                                bEo.bEl();
                                if (bEo.mWG.mXg) {
                                    bundle.putString("game_transparent_float_url", bEo.mWG.url);
                                }
                                bundle.putInt("game_sourceScene", intExtra);
                            }
                        }
                    } else {
                        bundle.remove("game_transparent_float_url");
                        bundle.remove("game_sourceScene");
                    }
                }
            }
            intent.putExtras(bundle);
            a(activity, intent, z, z2, z5, tabItem.mYr);
            AppMethodBeat.o(112280);
        }
    }

    public static void a(Activity activity, Intent intent, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(112281);
        String str = "MicroMsg.GameTabWidget";
        String str2 = "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b";
        Object[] objArr = new Object[5];
        objArr[0] = intent.getComponent() == null ? "" : intent.getComponent().getClassName();
        objArr[1] = Boolean.valueOf(z3);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = Boolean.valueOf(z4);
        ab.i(str, str2, objArr);
        str = "MicroMsg.GameTabWidget";
        String str3 = (z3 || z4) ? "straight to jump" : "jump to bridge";
        ab.i(str, str3);
        if (!z3 && z4) {
            ToolsProcessIPCService.a(null, a.class, null);
        }
        if (z3 || z4) {
            nnp = 0;
            intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            activity.startActivity(intent);
        } else {
            Intent intent2 = new Intent(activity, GameTabBridgeUI.class);
            intent2.putExtras(intent.getExtras());
            intent2.putExtra("next_tab_component", intent.getComponent());
            activity.startActivity(intent2);
        }
        if (!(!z2 || activity.isDestroyed() || activity.isFinishing())) {
            activity.finish();
        }
        if (z) {
            activity.overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.ync, com.tencent.mm.ui.MMFragmentActivity.a.ynd);
            AppMethodBeat.o(112281);
            return;
        }
        activity.overridePendingTransition(R.anim.bi, R.anim.bi);
        AppMethodBeat.o(112281);
    }

    static /* synthetic */ void a(GameTabWidget gameTabWidget) {
        AppMethodBeat.i(112282);
        int count = gameTabWidget.nnq.getCount();
        if (count != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bz.a.gd(gameTabWidget.mActivity) / count, -1);
            for (int i = 0; i < count; i++) {
                View view = gameTabWidget.nnq.getView(i, null, gameTabWidget);
                if (view != null) {
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(112273);
                            try {
                                GameTabWidget.a(GameTabWidget.this.mActivity, (TabItem) view.getTag(), false, false, false);
                                AppMethodBeat.o(112273);
                            } catch (Exception e) {
                                ab.e("MicroMsg.GameTabWidget", "selectTab err:%s", e.getMessage());
                                AppMethodBeat.o(112273);
                            }
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    gameTabWidget.addView(view);
                }
            }
        }
        AppMethodBeat.o(112282);
    }
}
