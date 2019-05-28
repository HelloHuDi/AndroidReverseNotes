package com.tencent.mm.plugin.webview.ui.tools.game.menu;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.ui.base.m;

public class GameMenuView extends LinearLayout {
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean uEM = false;
    private View uER;
    private LinearLayout uES;
    private LinearLayout uET;
    private f uEU;
    private c uEV;
    private a uEW;

    public GameMenuView(Context context) {
        boolean z = false;
        super(context, null);
        AppMethodBeat.i(8830);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            z = true;
        }
        this.uEM = z;
        initView();
        AppMethodBeat.o(8830);
    }

    public void setAdapter(f fVar) {
        AppMethodBeat.i(8831);
        this.uEU = fVar;
        fVar.registerDataSetObserver(new DataSetObserver() {
            public final void onInvalidated() {
                AppMethodBeat.i(8827);
                GameMenuView.a(GameMenuView.this);
                AppMethodBeat.o(8827);
            }

            public final void onChanged() {
                AppMethodBeat.i(8828);
                GameMenuView.a(GameMenuView.this);
                AppMethodBeat.o(8828);
            }
        });
        fVar.notifyDataSetChanged();
        AppMethodBeat.o(8831);
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AppMethodBeat.i(8832);
        this.mContext = context;
        initView();
        AppMethodBeat.o(8832);
    }

    private void initView() {
        View inflate;
        AppMethodBeat.i(8833);
        if (this.uEM) {
            setOrientation(0);
            this.mInflater.inflate(R.layout.a4z, this, true);
            inflate = this.mInflater.inflate(R.layout.a4w, this, true);
        } else {
            setOrientation(1);
            this.mInflater.inflate(R.layout.a50, this, true);
            inflate = this.mInflater.inflate(R.layout.a4x, this, true);
        }
        this.uER = inflate.findViewById(R.id.c7o);
        this.uES = (LinearLayout) inflate.findViewById(R.id.c7p);
        this.uET = (LinearLayout) inflate.findViewById(R.id.c7q);
        AppMethodBeat.o(8833);
    }

    public void setGameMenuItemSelectedListener(c cVar) {
        this.uEV = cVar;
    }

    public void setDismissListener(a aVar) {
        this.uEW = aVar;
    }

    static /* synthetic */ void a(GameMenuView gameMenuView) {
        AppMethodBeat.i(8834);
        int count = gameMenuView.uEU.getCount();
        if (count != 0) {
            int ge;
            LayoutParams layoutParams;
            View childAt;
            if (gameMenuView.uEM) {
                ge = com.tencent.mm.bz.a.ge(gameMenuView.mContext);
            } else {
                ge = com.tencent.mm.bz.a.gd(gameMenuView.mContext);
            }
            int am = ge - (com.tencent.mm.bz.a.am(gameMenuView.mContext, R.dimen.a2r) * 2);
            int am2 = com.tencent.mm.bz.a.am(gameMenuView.mContext, R.dimen.a2q);
            int am3 = com.tencent.mm.bz.a.am(gameMenuView.mContext, R.dimen.a2p);
            f fVar = gameMenuView.uEU;
            Object obj = (fVar.rBn == null || fVar.rBn.size() == 0) ? null : (fVar.rBn.size() + 1) / 2 > 4 ? 1 : null;
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
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(8829);
                            if (GameMenuView.this.uEV != null) {
                                GameMenuView.this.uEV.f((m) view.getTag());
                            }
                            if (GameMenuView.this.uEW != null) {
                                GameMenuView.this.uEW.onDismiss();
                            }
                            AppMethodBeat.o(8829);
                        }
                    });
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
                    AppMethodBeat.o(8834);
                    return;
                }
            } else if (gameMenuView.uES.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.uES.getParent()).setVisibility(8);
                AppMethodBeat.o(8834);
                return;
            } else if (gameMenuView.uET.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.uET.getParent()).setVisibility(8);
            }
        }
        AppMethodBeat.o(8834);
    }
}
