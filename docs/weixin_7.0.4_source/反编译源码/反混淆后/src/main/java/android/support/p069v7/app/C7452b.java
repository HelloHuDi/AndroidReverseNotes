package android.support.p069v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.NestedScrollView;
import android.support.p069v7.app.AlertController.C05583;
import android.support.p069v7.app.AlertController.C05594;
import android.support.p069v7.app.AlertController.C05605;
import android.support.p069v7.app.AlertController.C0565a;
import android.support.p069v7.app.AlertController.C0565a.C05611;
import android.support.p069v7.app.AlertController.C0565a.C05622;
import android.support.p069v7.app.AlertController.C0565a.C05633;
import android.support.p069v7.app.AlertController.C0565a.C05644;
import android.support.p069v7.app.AlertController.C0567c;
import android.support.p069v7.app.AlertController.C05682;
import android.support.p069v7.app.AlertController.RecycleListView;
import android.support.p069v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: android.support.v7.app.b */
public final class C7452b extends C6218i implements DialogInterface {
    /* renamed from: Uz */
    public final AlertController f2092Uz = new AlertController(getContext(), this, getWindow());

    /* renamed from: android.support.v7.app.b$a */
    public static class C0574a {
        /* renamed from: UA */
        public final C0565a f864UA;
        private final int mTheme;

        public C0574a(Context context) {
            this(context, C7452b.m12764j(context, 0));
        }

        private C0574a(Context context, int i) {
            this.f864UA = new C0565a(new ContextThemeWrapper(context, C7452b.m12764j(context, i)));
            this.mTheme = i;
        }

        /* renamed from: fi */
        public final C7452b mo1393fi() {
            int i;
            C7452b c7452b = new C7452b(this.f864UA.mContext, this.mTheme);
            C0565a c0565a = this.f864UA;
            AlertController alertController = c7452b.f2092Uz;
            if (c0565a.f764TG != null) {
                alertController.f806TG = c0565a.f764TG;
            } else {
                if (c0565a.f761IT != null) {
                    alertController.setTitle(c0565a.f761IT);
                }
                if (c0565a.f796rP != null) {
                    Drawable drawable = c0565a.f796rP;
                    alertController.f837rP = drawable;
                    alertController.f804TE = 0;
                    if (alertController.f838sX != null) {
                        if (drawable != null) {
                            alertController.f838sX.setVisibility(0);
                            alertController.f838sX.setImageDrawable(drawable);
                        } else {
                            alertController.f838sX.setVisibility(8);
                        }
                    }
                }
                if (c0565a.f763TE != 0) {
                    alertController.setIcon(c0565a.f763TE);
                }
                if (c0565a.f766TU != 0) {
                    i = c0565a.f766TU;
                    TypedValue typedValue = new TypedValue();
                    alertController.mContext.getTheme().resolveAttribute(i, typedValue, true);
                    alertController.setIcon(typedValue.resourceId);
                }
            }
            if (c0565a.f772Tk != null) {
                CharSequence charSequence = c0565a.f772Tk;
                alertController.f820Tk = charSequence;
                if (alertController.f836ma != null) {
                    alertController.f836ma.setText(charSequence);
                }
            }
            if (!(c0565a.f767TV == null && c0565a.f768TW == null)) {
                alertController.mo1378a(-1, c0565a.f767TV, c0565a.f769TX, null, c0565a.f768TW);
            }
            if (!(c0565a.f770TY == null && c0565a.f771TZ == null)) {
                alertController.mo1378a(-2, c0565a.f770TY, c0565a.f779Ua, null, c0565a.f771TZ);
            }
            if (!(c0565a.f780Ub == null && c0565a.f781Uc == null)) {
                alertController.mo1378a(-3, c0565a.f780Ub, c0565a.f782Ud, null, c0565a.f781Uc);
            }
            if (!(c0565a.f786Uh == null && c0565a.f762PI == null && c0565a.f760Ei == null)) {
                ListAdapter listAdapter;
                RecycleListView recycleListView = (RecycleListView) c0565a.mInflater.inflate(alertController.f810TK, null);
                Object listAdapter2;
                if (!c0565a.f789Uk) {
                    int i2;
                    if (c0565a.f790Ul) {
                        i2 = alertController.f812TM;
                    } else {
                        i2 = alertController.f813TN;
                    }
                    if (c0565a.f762PI != null) {
                        listAdapter2 = new SimpleCursorAdapter(c0565a.mContext, i2, c0565a.f762PI, new String[]{c0565a.f792Un}, new int[]{16908308});
                    } else if (c0565a.f760Ei != null) {
                        listAdapter2 = c0565a.f760Ei;
                    } else {
                        listAdapter2 = new C0567c(c0565a.mContext, i2, c0565a.f786Uh);
                    }
                } else if (c0565a.f762PI == null) {
                    listAdapter2 = new C05611(c0565a.mContext, alertController.f811TL, c0565a.f786Uh, recycleListView);
                } else {
                    listAdapter2 = new C05622(c0565a.mContext, c0565a.f762PI, recycleListView, alertController);
                }
                alertController.f798Ei = listAdapter2;
                alertController.f807TH = c0565a.f765TH;
                if (c0565a.f787Ui != null) {
                    recycleListView.setOnItemClickListener(new C05633(alertController));
                } else if (c0565a.f791Um != null) {
                    recycleListView.setOnItemClickListener(new C05644(recycleListView, alertController));
                }
                if (c0565a.f794Up != null) {
                    recycleListView.setOnItemSelectedListener(c0565a.f794Up);
                }
                if (c0565a.f790Ul) {
                    recycleListView.setChoiceMode(1);
                } else if (c0565a.f789Uk) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.mListView = recycleListView;
            }
            if (c0565a.mView != null) {
                if (c0565a.f778Tq) {
                    View view = c0565a.mView;
                    int i3 = c0565a.f774Tm;
                    int i4 = c0565a.f775Tn;
                    int i5 = c0565a.f776To;
                    int i6 = c0565a.f777Tp;
                    alertController.mView = view;
                    alertController.f821Tl = 0;
                    alertController.f826Tq = true;
                    alertController.f822Tm = i3;
                    alertController.f823Tn = i4;
                    alertController.f824To = i5;
                    alertController.f825Tp = i6;
                } else {
                    alertController.mView = c0565a.mView;
                    alertController.f821Tl = 0;
                    alertController.f826Tq = false;
                }
            } else if (c0565a.f773Tl != 0) {
                i = c0565a.f773Tl;
                alertController.mView = null;
                alertController.f821Tl = i;
                alertController.f826Tq = false;
            }
            c7452b.setCancelable(this.f864UA.mCancelable);
            if (this.f864UA.mCancelable) {
                c7452b.setCanceledOnTouchOutside(true);
            }
            c7452b.setOnCancelListener(this.f864UA.f783Ue);
            c7452b.setOnDismissListener(this.f864UA.f784Uf);
            if (this.f864UA.f785Ug != null) {
                c7452b.setOnKeyListener(this.f864UA.f785Ug);
            }
            return c7452b;
        }
    }

    protected C7452b(Context context, int i) {
        super(context, C7452b.m12764j(context, i));
    }

    /* renamed from: j */
    static int m12764j(Context context, int i) {
        if (((i >>> 24) & 255) > 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C25738R.attr.f5693fy, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f2092Uz.setTitle(charSequence);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        int i;
        View view;
        int indexOfChild;
        Object obj;
        int i2;
        super.onCreate(bundle);
        AlertController alertController = this.f2092Uz;
        if (alertController.f809TJ == 0 || alertController.f815TP != 1) {
            i = alertController.f808TI;
        } else {
            i = alertController.f809TJ;
        }
        alertController.f817Th.setContentView(i);
        View findViewById = alertController.f818Ti.findViewById(2131820918);
        View findViewById2 = findViewById.findViewById(2131820927);
        View findViewById3 = findViewById.findViewById(2131820919);
        View findViewById4 = findViewById.findViewById(2131820916);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(2131820925);
        if (alertController.mView != null) {
            view = alertController.mView;
        } else if (alertController.f821Tl != 0) {
            view = LayoutInflater.from(alertController.mContext).inflate(alertController.f821Tl, viewGroup, false);
        } else {
            view = null;
        }
        Object obj2 = view != null ? 1 : null;
        if (obj2 == null || !AlertController.m1240aQ(view)) {
            alertController.f818Ti.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (obj2 != null) {
            FrameLayout frameLayout = (FrameLayout) alertController.f818Ti.findViewById(2131820926);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (alertController.f826Tq) {
                frameLayout.setPadding(alertController.f822Tm, alertController.f823Tn, alertController.f824To, alertController.f825Tp);
            }
            if (alertController.mListView != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(2131820927);
        view = viewGroup.findViewById(2131820919);
        View findViewById6 = viewGroup.findViewById(2131820916);
        ViewGroup c = AlertController.m1241c(findViewById5, findViewById2);
        ViewGroup c2 = AlertController.m1241c(view, findViewById3);
        ViewGroup c3 = AlertController.m1241c(findViewById6, findViewById4);
        alertController.f803TD = (NestedScrollView) alertController.f818Ti.findViewById(2131820921);
        alertController.f803TD.setFocusable(false);
        alertController.f803TD.setNestedScrollingEnabled(false);
        alertController.f836ma = (TextView) c2.findViewById(16908299);
        if (alertController.f836ma != null) {
            if (alertController.f820Tk != null) {
                alertController.f836ma.setText(alertController.f820Tk);
            } else {
                alertController.f836ma.setVisibility(8);
                alertController.f803TD.removeView(alertController.f836ma);
                if (alertController.mListView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.f803TD.getParent();
                    indexOfChild = viewGroup2.indexOfChild(alertController.f803TD);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.mListView, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    c2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        alertController.f827Tr = (Button) c3.findViewById(16908313);
        alertController.f827Tr.setOnClickListener(alertController.f816TQ);
        if (TextUtils.isEmpty(alertController.f828Ts) && alertController.f830Tu == null) {
            alertController.f827Tr.setVisibility(8);
        } else {
            alertController.f827Tr.setText(alertController.f828Ts);
            if (alertController.f830Tu != null) {
                alertController.f830Tu.setBounds(0, 0, alertController.f819Tj, alertController.f819Tj);
                alertController.f827Tr.setCompoundDrawables(alertController.f830Tu, null, null, null);
            }
            alertController.f827Tr.setVisibility(0);
            indexOfChild = 1;
        }
        alertController.f831Tv = (Button) c3.findViewById(16908314);
        alertController.f831Tv.setOnClickListener(alertController.f816TQ);
        if (TextUtils.isEmpty(alertController.f832Tw) && alertController.f834Ty == null) {
            alertController.f831Tv.setVisibility(8);
        } else {
            alertController.f831Tv.setText(alertController.f832Tw);
            if (alertController.f834Ty != null) {
                alertController.f834Ty.setBounds(0, 0, alertController.f819Tj, alertController.f819Tj);
                alertController.f831Tv.setCompoundDrawables(alertController.f834Ty, null, null, null);
            }
            alertController.f831Tv.setVisibility(0);
            indexOfChild |= 2;
        }
        alertController.f835Tz = (Button) c3.findViewById(16908315);
        alertController.f835Tz.setOnClickListener(alertController.f816TQ);
        if (TextUtils.isEmpty(alertController.f800TA) && alertController.f802TC == null) {
            alertController.f835Tz.setVisibility(8);
        } else {
            alertController.f835Tz.setText(alertController.f800TA);
            if (alertController.f830Tu != null) {
                alertController.f830Tu.setBounds(0, 0, alertController.f819Tj, alertController.f819Tj);
                alertController.f827Tr.setCompoundDrawables(alertController.f830Tu, null, null, null);
            }
            alertController.f835Tz.setVisibility(0);
            indexOfChild |= 4;
        }
        Context context = alertController.mContext;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C25738R.attr.f5692fx, typedValue, true);
        if (typedValue.data != 0) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (indexOfChild == 1) {
                AlertController.m1239a(alertController.f827Tr);
            } else if (indexOfChild == 2) {
                AlertController.m1239a(alertController.f831Tv);
            } else if (indexOfChild == 4) {
                AlertController.m1239a(alertController.f835Tz);
            }
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            c3.setVisibility(8);
        }
        if (alertController.f806TG != null) {
            c.addView(alertController.f806TG, 0, new LayoutParams(-1, -2));
            alertController.f818Ti.findViewById(2131820928).setVisibility(8);
        } else {
            alertController.f838sX = (ImageView) alertController.f818Ti.findViewById(16908294);
            if ((!TextUtils.isEmpty(alertController.f799IT) ? 1 : null) == null || !alertController.f814TO) {
                alertController.f818Ti.findViewById(2131820928).setVisibility(8);
                alertController.f838sX.setVisibility(8);
                c.setVisibility(8);
            } else {
                alertController.f805TF = (TextView) alertController.f818Ti.findViewById(2131820929);
                alertController.f805TF.setText(alertController.f799IT);
                if (alertController.f804TE != 0) {
                    alertController.f838sX.setImageResource(alertController.f804TE);
                } else if (alertController.f837rP != null) {
                    alertController.f838sX.setImageDrawable(alertController.f837rP);
                } else {
                    alertController.f805TF.setPadding(alertController.f838sX.getPaddingLeft(), alertController.f838sX.getPaddingTop(), alertController.f838sX.getPaddingRight(), alertController.f838sX.getPaddingBottom());
                    alertController.f838sX.setVisibility(8);
                }
            }
        }
        Object obj3 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        Object obj4 = (c == null || c.getVisibility() == 8) ? null : 1;
        if (c3 == null || c3.getVisibility() == 8) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null && c2 != null) {
            findViewById = c2.findViewById(2131820923);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (obj4 != null) {
            if (alertController.f803TD != null) {
                alertController.f803TD.setClipToPadding(true);
            }
            findViewById = null;
            if (!(alertController.f820Tk == null && alertController.mListView == null)) {
                findViewById = c.findViewById(2131820930);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (c2 != null) {
            findViewById = c2.findViewById(2131820922);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (alertController.mListView instanceof RecycleListView) {
            RecycleListView recycleListView = (RecycleListView) alertController.mListView;
            if (obj == null || obj4 == null) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), obj4 != null ? recycleListView.getPaddingTop() : recycleListView.f746Ux, recycleListView.getPaddingRight(), obj != null ? recycleListView.getPaddingBottom() : recycleListView.f747Uy);
            }
        }
        if (obj3 == null) {
            view = alertController.mListView != null ? alertController.mListView : alertController.f803TD;
            if (view != null) {
                if (obj4 != null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (obj != null) {
                    i = 2;
                } else {
                    i = 0;
                }
                int i3 = i2 | i;
                findViewById5 = alertController.f818Ti.findViewById(2131820920);
                findViewById = alertController.f818Ti.findViewById(2131820924);
                if (VERSION.SDK_INT >= 23) {
                    C0477s.m953s(view, i3);
                    if (findViewById5 != null) {
                        c2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        c2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i3 & 1) == 0) {
                        c2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i3 & 2) == 0) {
                        c2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (alertController.f820Tk != null) {
                            alertController.f803TD.setOnScrollChangeListener(new C05682(findViewById5, findViewById));
                            alertController.f803TD.post(new C05583(findViewById5, findViewById));
                        } else if (alertController.mListView != null) {
                            alertController.mListView.setOnScrollListener(new C05594(findViewById5, findViewById));
                            alertController.mListView.post(new C05605(findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                c2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                c2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = alertController.mListView;
        if (listView != null && alertController.f798Ei != null) {
            listView.setAdapter(alertController.f798Ei);
            i2 = alertController.f807TH;
            if (i2 >= 0) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        AlertController alertController = this.f2092Uz;
        if (alertController.f803TD == null || !alertController.f803TD.executeKeyEvent(keyEvent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z;
        AlertController alertController = this.f2092Uz;
        if (alertController.f803TD == null || !alertController.f803TD.executeKeyEvent(keyEvent)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
