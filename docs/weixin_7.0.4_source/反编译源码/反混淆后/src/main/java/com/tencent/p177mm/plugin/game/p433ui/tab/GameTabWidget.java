package com.tencent.p177mm.plugin.game.p433ui.tab;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.plugin.game.model.C21004l;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C39215q;
import com.tencent.p177mm.plugin.game.model.GameTabData;
import com.tencent.p177mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWidget */
public class GameTabWidget extends LinearLayout {
    public static int nnp = 0;
    private Activity mActivity;
    private C39239a nnq;

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWidget$a */
    public static class C21043a implements C37866a<Bundle, Bundle> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(112274);
            Bundle bundle = (Bundle) obj;
            if (c18507c != null) {
                c18507c.mo5960ao(bundle);
            }
            AppMethodBeat.m2505o(112274);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWidget$1 */
    class C392381 extends DataSetObserver {
        C392381() {
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(112271);
            GameTabWidget.m76852a(GameTabWidget.this);
            AppMethodBeat.m2505o(112271);
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(112272);
            GameTabWidget.m76852a(GameTabWidget.this);
            AppMethodBeat.m2505o(112272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.GameTabWidget$2 */
    class C432112 implements OnClickListener {
        C432112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112273);
            try {
                GameTabWidget.m76851a(GameTabWidget.this.mActivity, (TabItem) view.getTag(), false, false, false);
                AppMethodBeat.m2505o(112273);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.GameTabWidget", "selectTab err:%s", e.getMessage());
                AppMethodBeat.m2505o(112273);
            }
        }
    }

    public GameTabWidget(Context context) {
        super(context);
        AppMethodBeat.m2504i(112275);
        m76854cA(context);
        AppMethodBeat.m2505o(112275);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112276);
        m76854cA(context);
        AppMethodBeat.m2505o(112276);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112277);
        m76854cA(context);
        AppMethodBeat.m2505o(112277);
    }

    /* renamed from: cA */
    private void m76854cA(Context context) {
        AppMethodBeat.m2504i(112278);
        this.mActivity = (Activity) context;
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(C25738R.color.f12039qa);
        setOrientation(0);
        AppMethodBeat.m2505o(112278);
    }

    public void setAdapter(C39239a c39239a) {
        AppMethodBeat.m2504i(112279);
        this.nnq = c39239a;
        c39239a.registerDataSetObserver(new C392381());
        c39239a.notifyDataSetChanged();
        AppMethodBeat.m2505o(112279);
    }

    /* renamed from: a */
    public static void m76851a(Activity activity, TabItem tabItem, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(112280);
        if (activity == null || tabItem == null) {
            AppMethodBeat.m2505o(112280);
        } else if (C46001c.m85456ay(activity, tabItem.jumpUrl)) {
            AppMethodBeat.m2505o(112280);
        } else {
            String stringExtra = activity.getIntent().getStringExtra("tab_key");
            if (C5046bo.nullAsNil(tabItem.mYp).equals(stringExtra)) {
                AppMethodBeat.m2505o(112280);
                return;
            }
            boolean z4;
            boolean z5;
            C4990ab.m7417i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", activity.getClass().getSimpleName(), tabItem.mYw, Boolean.valueOf(z));
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
                TabItem tabItem2 = (TabItem) gameTabData.mYm.get(C5046bo.nullAsNil(stringExtra));
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
                C34277b.m56211a(activity, 18, tabItem.cKG, tabItem.mYy, 2, null, activity.getIntent().getIntExtra("game_report_from_scene", 0), C34276a.m56208kY(tabItem.mVB));
            }
            if (!tabItem.mYr) {
                bundle.putString("rawUrl", tabItem.jumpUrl);
                bundle.putBoolean("KRightBtn", true);
                bundle.putBoolean("isWebwx", true);
                bundle.putBoolean("show_bottom", false);
                bundle.putString("title", activity.getString(C25738R.string.c8c));
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
                if (!C5046bo.isNullOrNil(string)) {
                    if (z3) {
                        z4 = intent.getBooleanExtra("from_find_more_friend", false);
                        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
                        if (z4) {
                            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                            C28229n bEo = C39215q.bEo();
                            if (bEo == null) {
                                ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
                                bEo = C39215q.bEs();
                            }
                            bundle.putString("rawUrl", C21004l.m32301a(string, bEo));
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
            GameTabWidget.m76850a(activity, intent, z, z2, z5, tabItem.mYr);
            AppMethodBeat.m2505o(112280);
        }
    }

    /* renamed from: a */
    public static void m76850a(Activity activity, Intent intent, boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.m2504i(112281);
        String str = "MicroMsg.GameTabWidget";
        String str2 = "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b";
        Object[] objArr = new Object[5];
        objArr[0] = intent.getComponent() == null ? "" : intent.getComponent().getClassName();
        objArr[1] = Boolean.valueOf(z3);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = Boolean.valueOf(z4);
        C4990ab.m7417i(str, str2, objArr);
        str = "MicroMsg.GameTabWidget";
        String str3 = (z3 || z4) ? "straight to jump" : "jump to bridge";
        C4990ab.m7416i(str, str3);
        if (!z3 && z4) {
            ToolsProcessIPCService.m63913a(null, C21043a.class, null);
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
            activity.overridePendingTransition(C5206a.ync, C5206a.ynd);
            AppMethodBeat.m2505o(112281);
            return;
        }
        activity.overridePendingTransition(C25738R.anim.f8344bi, C25738R.anim.f8344bi);
        AppMethodBeat.m2505o(112281);
    }

    /* renamed from: a */
    static /* synthetic */ void m76852a(GameTabWidget gameTabWidget) {
        AppMethodBeat.m2504i(112282);
        int count = gameTabWidget.nnq.getCount();
        if (count != 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C1338a.m2868gd(gameTabWidget.mActivity) / count, -1);
            for (int i = 0; i < count; i++) {
                View view = gameTabWidget.nnq.getView(i, null, gameTabWidget);
                if (view != null) {
                    view.setOnClickListener(new C432112());
                    view.setLayoutParams(layoutParams);
                    gameTabWidget.addView(view);
                }
            }
        }
        AppMethodBeat.m2505o(112282);
    }
}
