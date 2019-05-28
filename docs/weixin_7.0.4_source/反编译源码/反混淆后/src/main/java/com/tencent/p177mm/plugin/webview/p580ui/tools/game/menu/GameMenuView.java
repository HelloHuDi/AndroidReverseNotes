package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C14617c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C40317a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView */
public class GameMenuView extends LinearLayout {
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean uEM = false;
    private View uER;
    private LinearLayout uES;
    private LinearLayout uET;
    private C29925f uEU;
    private C14617c uEV;
    private C40317a uEW;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView$1 */
    class C46251 extends DataSetObserver {
        C46251() {
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(8827);
            GameMenuView.m6988a(GameMenuView.this);
            AppMethodBeat.m2505o(8827);
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(8828);
            GameMenuView.m6988a(GameMenuView.this);
            AppMethodBeat.m2505o(8828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuView$2 */
    class C46262 implements OnClickListener {
        C46262() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(8829);
            if (GameMenuView.this.uEV != null) {
                GameMenuView.this.uEV.mo26874f((C44274m) view.getTag());
            }
            if (GameMenuView.this.uEW != null) {
                GameMenuView.this.uEW.onDismiss();
            }
            AppMethodBeat.m2505o(8829);
        }
    }

    public GameMenuView(Context context) {
        boolean z = false;
        super(context, null);
        AppMethodBeat.m2504i(8830);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            z = true;
        }
        this.uEM = z;
        initView();
        AppMethodBeat.m2505o(8830);
    }

    public void setAdapter(C29925f c29925f) {
        AppMethodBeat.m2504i(8831);
        this.uEU = c29925f;
        c29925f.registerDataSetObserver(new C46251());
        c29925f.notifyDataSetChanged();
        AppMethodBeat.m2505o(8831);
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AppMethodBeat.m2504i(8832);
        this.mContext = context;
        initView();
        AppMethodBeat.m2505o(8832);
    }

    private void initView() {
        View inflate;
        AppMethodBeat.m2504i(8833);
        if (this.uEM) {
            setOrientation(0);
            this.mInflater.inflate(2130969752, this, true);
            inflate = this.mInflater.inflate(2130969749, this, true);
        } else {
            setOrientation(1);
            this.mInflater.inflate(2130969753, this, true);
            inflate = this.mInflater.inflate(2130969750, this, true);
        }
        this.uER = inflate.findViewById(2131824565);
        this.uES = (LinearLayout) inflate.findViewById(2131824566);
        this.uET = (LinearLayout) inflate.findViewById(2131824567);
        AppMethodBeat.m2505o(8833);
    }

    public void setGameMenuItemSelectedListener(C14617c c14617c) {
        this.uEV = c14617c;
    }

    public void setDismissListener(C40317a c40317a) {
        this.uEW = c40317a;
    }

    /* renamed from: a */
    static /* synthetic */ void m6988a(GameMenuView gameMenuView) {
        AppMethodBeat.m2504i(8834);
        int count = gameMenuView.uEU.getCount();
        if (count != 0) {
            int ge;
            LayoutParams layoutParams;
            View childAt;
            if (gameMenuView.uEM) {
                ge = C1338a.m2869ge(gameMenuView.mContext);
            } else {
                ge = C1338a.m2868gd(gameMenuView.mContext);
            }
            int am = ge - (C1338a.m2857am(gameMenuView.mContext, C25738R.dimen.a2r) * 2);
            int am2 = C1338a.m2857am(gameMenuView.mContext, C25738R.dimen.a2q);
            int am3 = C1338a.m2857am(gameMenuView.mContext, C25738R.dimen.a2p);
            C29925f c29925f = gameMenuView.uEU;
            Object obj = (c29925f.rBn == null || c29925f.rBn.size() == 0) ? null : (c29925f.rBn.size() + 1) / 2 > 4 ? 1 : null;
            if (obj != null) {
                if (gameMenuView.uEM) {
                    ge = (int) (((((double) am) - (0.375d * ((double) am3))) - ((double) (am3 * 4))) / 9.0d);
                } else {
                    ge = (int) (((((double) am) - (0.5d * ((double) am2))) - ((double) (am2 * 4))) / 9.0d);
                }
            } else if (gameMenuView.uEM) {
                ge = (int) (((double) (am - (am3 * 4))) / 8.0d);
            } else {
                ge = (int) (((double) (am - (am2 * 4))) / 8.0d);
            }
            if (gameMenuView.uEM) {
                if (ge > 0) {
                    layoutParams = new LinearLayout.LayoutParams(am3, (ge * 2) + am3);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(am3, am3);
                }
            } else if (ge > 0) {
                layoutParams = new LinearLayout.LayoutParams((ge * 2) + am2, am2);
            } else {
                layoutParams = new LinearLayout.LayoutParams(am2, am2);
            }
            for (am = 0; am < count; am++) {
                View view = gameMenuView.uEU.getView(am, null, gameMenuView.uES);
                if (view != null) {
                    view.setOnClickListener(new C46262());
                    view.setLayoutParams(layoutParams);
                    if (am % 2 == 0) {
                        gameMenuView.uES.addView(view);
                    } else {
                        gameMenuView.uET.addView(view);
                    }
                }
            }
            while (true) {
                ge = gameMenuView.uES.getChildCount();
                if (ge <= 0) {
                    break;
                }
                childAt = gameMenuView.uES.getChildAt(ge - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.uES.removeViewAt(ge - 1);
            }
            while (true) {
                ge = gameMenuView.uET.getChildCount();
                if (ge <= 0) {
                    break;
                }
                childAt = gameMenuView.uET.getChildAt(ge - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.uET.removeViewAt(ge - 1);
            }
            if (gameMenuView.uES.getChildCount() == 0 && gameMenuView.uET.getChildCount() == 0) {
                if (gameMenuView.uEW != null) {
                    gameMenuView.uEW.onDismiss();
                    AppMethodBeat.m2505o(8834);
                    return;
                }
            } else if (gameMenuView.uES.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.uES.getParent()).setVisibility(8);
                AppMethodBeat.m2505o(8834);
                return;
            } else if (gameMenuView.uET.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.uET.getParent()).setVisibility(8);
            }
        }
        AppMethodBeat.m2505o(8834);
    }
}
