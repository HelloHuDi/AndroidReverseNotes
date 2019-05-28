package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.api.u;
import com.tencent.mm.br.b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.ae;
import com.tencent.mm.view.footer.SelectColorBar;

public abstract class a extends c implements OnGlobalLayoutListener {
    private com.tencent.mm.api.s.a ccP;
    public boolean ccT = true;
    private com.tencent.mm.view.b.a ccv;
    private b cjc;
    private View iJO;
    private Button lXI;
    private Button oDB;
    public ChatFooterPanel odY;
    protected e[] zZM;
    private View zZN;
    private com.tencent.mm.view.footer.a zZO;
    private View zZP;
    private View zZQ;
    private PhotoEditText zZR;
    private Switch zZS;
    private boolean zZT = true;

    public abstract com.tencent.mm.view.b.a dMG();

    public abstract com.tencent.mm.view.footer.a dMH();

    public abstract e[] getFeatures();

    public a(Context context, com.tencent.mm.api.s.a aVar) {
        super(context);
        this.ccP = aVar;
        getPresenter().a(getConfig());
        removeAllViews();
        addView(getBaseBoardView(), new LayoutParams(-1, -1));
        LayoutParams layoutParams = new LayoutParams(-1, (int) getResources().getDimension(R.dimen.a24));
        layoutParams.gravity = 80;
        addView(getFooterBg(), layoutParams);
        addView(getBaseFooterView(), layoutParams);
        layoutParams = new LayoutParams(-1, -1);
        getTextEditView().setVisibility(8);
        addView(getTextEditView(), layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        getRubbishView().setVisibility(8);
        addView(getRubbishView(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(R.dimen.a0f));
        layoutParams.gravity = 80;
        addView(getChatFooterPanel(), layoutParams);
        new LayoutParams(-1, (int) getResources().getDimension(R.dimen.fc)).gravity = 48;
        if (this.ccP.ccT) {
            addView(getActionBar());
        }
    }

    public com.tencent.mm.api.s.a getConfig() {
        return this.ccP;
    }

    public <T extends com.tencent.mm.view.footer.a> T getBaseFooterView() {
        if (this.zZO == null) {
            this.zZO = dMH();
        }
        return this.zZO;
    }

    public <T extends com.tencent.mm.view.b.a> T getBaseBoardView() {
        if (this.ccv == null) {
            this.ccv = dMG();
        }
        return this.ccv;
    }

    public View getFooterBg() {
        if (this.zZN == null) {
            this.zZN = LayoutInflater.from(getContext()).inflate(R.layout.a0f, null);
            this.zZN.setVisibility(0);
        }
        return this.zZN;
    }

    public View getActionBar() {
        if (this.iJO == null) {
            int hC;
            this.iJO = LayoutInflater.from(getContext()).inflate(R.layout.akf, null);
            if (ae.hD(getContext())) {
                hC = ae.hC(getContext()) + 0;
            } else {
                hC = 0;
            }
            this.iJO.setPadding(0, hC, 0, 0);
            this.oDB = (Button) this.iJO.findViewById(R.id.dn6);
            this.oDB.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(116371);
                    if (a.this.getTextEditView().getVisibility() == 0) {
                        a.this.getPresenter().a(a.this.zZR.getText(), a.this.zZR.getCurrentTextColor(), a.this.zZS.isChecked() ? ((Integer) a.this.zZS.getTag()).intValue() : 0);
                        AppMethodBeat.o(116371);
                        return;
                    }
                    a.this.getPresenter().onFinish();
                    AppMethodBeat.o(116371);
                }
            });
            this.lXI = (Button) this.iJO.findViewById(R.id.dn5);
            this.lXI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(116377);
                    if (a.this.getTextEditView().getVisibility() == 0) {
                        a.this.getPresenter().dlS();
                        AppMethodBeat.o(116377);
                        return;
                    }
                    a.this.getPresenter().onExit();
                    AppMethodBeat.o(116377);
                }
            });
        }
        return this.iJO;
    }

    public View getTextEditView() {
        if (this.zZP == null) {
            this.zZP = LayoutInflater.from(getContext()).inflate(R.layout.tb, null);
            this.zZR = (PhotoEditText) this.zZP.findViewById(R.id.bbt);
            int dimension = (int) this.zZR.getResources().getDimension(R.dimen.zi);
            int dimension2 = (int) this.zZR.getResources().getDimension(R.dimen.xe);
            if (ae.hD(getContext())) {
                dimension2 += ae.hC(getContext());
            }
            this.zZR.setPadding(dimension, dimension2, dimension, 0);
            final SelectColorBar selectColorBar = (SelectColorBar) this.zZP.findViewById(R.id.bbv);
            this.zZS = (Switch) this.zZP.findViewById(R.id.bbu);
            this.zZS.setTag(Integer.valueOf(-707825));
            this.zZS.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(116378);
                    if (z) {
                        selectColorBar.setSelectColor(((Integer) a.this.zZS.getTag()).intValue());
                        a.this.zZR.setTextBackground(((Integer) a.this.zZS.getTag()).intValue());
                        AppMethodBeat.o(116378);
                        return;
                    }
                    a.this.zZS.setTag(Integer.valueOf(selectColorBar.getCurColor()));
                    a.this.zZR.setTextBackground(0);
                    AppMethodBeat.o(116378);
                }
            });
            this.zZR.setTextColor(-1);
            selectColorBar.setSelectColor(-1);
            selectColorBar.setSelectColorListener(new com.tencent.mm.view.footer.SelectColorBar.a() {
                public final void Qy(int i) {
                    AppMethodBeat.i(116379);
                    if (a.this.zZS.isChecked()) {
                        a.this.zZS.setTag(Integer.valueOf(i));
                        a.this.zZR.setTextBackground(i);
                        AppMethodBeat.o(116379);
                        return;
                    }
                    a.this.zZR.setTextColor(i);
                    AppMethodBeat.o(116379);
                }
            });
        }
        return this.zZP;
    }

    public View getRubbishView() {
        if (this.zZP == null) {
            this.zZQ = LayoutInflater.from(getContext()).inflate(R.layout.ap2, null);
        }
        return this.zZQ;
    }

    public ChatFooterPanel getChatFooterPanel() {
        boolean z = false;
        if (this.odY == null) {
            try {
                this.odY = u.aR(getContext());
                this.odY.setEntranceScene(ChatFooterPanel.vhk);
                this.odY.setBackgroundResource(R.drawable.ay1);
                this.odY.AE();
                this.odY.bf(true);
                this.odY.j(true, true);
                this.odY.setVisibility(8);
                this.odY.onResume();
                t AH = u.AH();
                AH.ccZ = new com.tencent.mm.api.t.a() {
                    public final void a(k kVar) {
                        AppMethodBeat.i(116380);
                        ab.i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", kVar);
                        a.this.getPresenter().d(kVar);
                        onHide();
                        AppMethodBeat.o(116380);
                    }

                    public final void onHide() {
                        AppMethodBeat.i(116381);
                        a.this.setActionBarVisible(true);
                        a.this.rj(true);
                        a.this.setFooterVisible(true);
                        AppMethodBeat.o(116381);
                    }
                };
                this.odY.setCallback(AH);
            } catch (Exception e) {
                String str = "MicroMsg.BaseDrawingView";
                String str2 = "exception:%s,getContext() is null?";
                Object[] objArr = new Object[2];
                objArr[0] = e.getMessage();
                if (getContext() == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                ab.e(str, str2, objArr);
                throw e;
            }
        }
        return this.odY;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(116382);
                a.this.getPresenter().onAttachedToWindow();
                AppMethodBeat.o(116382);
            }
        });
    }

    public b getPresenter() {
        if (this.cjc == null) {
            this.cjc = new com.tencent.mm.br.a();
            this.cjc.a(this);
        }
        return this.cjc;
    }

    public void setActionBarCallback(g gVar) {
        getPresenter().setActionBarCallback(gVar);
    }

    public void setAutoShowFooterAndBar(boolean z) {
        getPresenter().setAutoShowFooterAndBar(z);
    }

    public void setFooterVisible(boolean z) {
        if (this.zZT != z) {
            getBaseFooterView().setFooterVisible(z);
            setFooterBgVisible(z);
            this.zZT = z;
        }
    }

    public void setActionBarVisible(boolean z) {
        if (this.ccT == z) {
            ab.w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
            return;
        }
        this.ccT = z;
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.n);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(116383);
                    a.this.getActionBar().setVisibility(0);
                    a.this.getFooterBg().setVisibility(0);
                    AppMethodBeat.o(116383);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.o);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(116384);
                a.this.getActionBar().setVisibility(8);
                a.this.getFooterBg().setVisibility(8);
                AppMethodBeat.o(116384);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        getActionBar().startAnimation(loadAnimation);
    }

    public void setFooterBgVisible(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.n);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(116385);
                    a.this.getFooterBg().setVisibility(0);
                    a.this.getActionBar().setVisibility(0);
                    AppMethodBeat.o(116385);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.o);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(116372);
                a.this.getFooterBg().setVisibility(8);
                a.this.getActionBar().setVisibility(8);
                AppMethodBeat.o(116372);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        getActionBar().startAnimation(loadAnimation);
    }

    public final void rj(boolean z) {
        ab.i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", Boolean.valueOf(z));
        Animation loadAnimation;
        if (this.odY.getVisibility() == 0 && z) {
            this.odY.setVisibility(8);
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ce);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(116373);
                    a.this.odY.setVisibility(0);
                    AppMethodBeat.o(116373);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(116374);
                    a.this.odY.setVisibility(8);
                    AppMethodBeat.o(116374);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.odY.startAnimation(loadAnimation);
        } else if (this.odY.getVisibility() == 8 && !z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.cg);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(116375);
                    a.this.odY.setVisibility(0);
                    AppMethodBeat.o(116375);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.odY.startAnimation(loadAnimation);
        }
    }

    public void onGlobalLayout() {
        if (getTextEditView().getVisibility() == 0) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.zZR.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(116376);
                    Rect rect = new Rect();
                    a.this.getWindowVisibleDisplayFrame(rect);
                    int i = a.this.getBottom() - rect.bottom >= 300 ? 1 : 0;
                    a.this.getResources().getDisplayMetrics();
                    if (i == 0) {
                        i = a.this.getBottom() - ((int) a.this.getResources().getDimension(R.dimen.xe));
                    } else {
                        i = (a.this.getBottom() - j.Mw()) - ((int) a.this.getResources().getDimension(R.dimen.xe));
                        ab.e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", Integer.valueOf(i));
                    }
                    if (a.this.zZR.getHeight() != i) {
                        a.this.zZR.setHeight(i);
                    }
                    a.this.getViewTreeObserver().removeOnGlobalLayoutListener(a.this);
                    a.this.getViewTreeObserver().addOnGlobalLayoutListener(a.this);
                    AppMethodBeat.o(116376);
                }
            }, 160);
        }
    }
}
