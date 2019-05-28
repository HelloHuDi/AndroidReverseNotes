package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.s;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AlertController.AnonymousClass5;
import android.support.v7.app.AlertController.RecycleListView;
import android.support.v7.app.AlertController.a.AnonymousClass1;
import android.support.v7.app.AlertController.a.AnonymousClass2;
import android.support.v7.app.AlertController.a.AnonymousClass3;
import android.support.v7.app.AlertController.a.AnonymousClass4;
import android.support.v7.widget.LinearLayoutCompat;
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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class b extends i implements DialogInterface {
    public final AlertController Uz = new AlertController(getContext(), this, getWindow());

    public static class a {
        public final android.support.v7.app.AlertController.a UA;
        private final int mTheme;

        public a(Context context) {
            this(context, b.j(context, 0));
        }

        private a(Context context, int i) {
            this.UA = new android.support.v7.app.AlertController.a(new ContextThemeWrapper(context, b.j(context, i)));
            this.mTheme = i;
        }

        public final b fi() {
            int i;
            b bVar = new b(this.UA.mContext, this.mTheme);
            android.support.v7.app.AlertController.a aVar = this.UA;
            AlertController alertController = bVar.Uz;
            if (aVar.TG != null) {
                alertController.TG = aVar.TG;
            } else {
                if (aVar.IT != null) {
                    alertController.setTitle(aVar.IT);
                }
                if (aVar.rP != null) {
                    Drawable drawable = aVar.rP;
                    alertController.rP = drawable;
                    alertController.TE = 0;
                    if (alertController.sX != null) {
                        if (drawable != null) {
                            alertController.sX.setVisibility(0);
                            alertController.sX.setImageDrawable(drawable);
                        } else {
                            alertController.sX.setVisibility(8);
                        }
                    }
                }
                if (aVar.TE != 0) {
                    alertController.setIcon(aVar.TE);
                }
                if (aVar.TU != 0) {
                    i = aVar.TU;
                    TypedValue typedValue = new TypedValue();
                    alertController.mContext.getTheme().resolveAttribute(i, typedValue, true);
                    alertController.setIcon(typedValue.resourceId);
                }
            }
            if (aVar.Tk != null) {
                CharSequence charSequence = aVar.Tk;
                alertController.Tk = charSequence;
                if (alertController.ma != null) {
                    alertController.ma.setText(charSequence);
                }
            }
            if (!(aVar.TV == null && aVar.TW == null)) {
                alertController.a(-1, aVar.TV, aVar.TX, null, aVar.TW);
            }
            if (!(aVar.TY == null && aVar.TZ == null)) {
                alertController.a(-2, aVar.TY, aVar.Ua, null, aVar.TZ);
            }
            if (!(aVar.Ub == null && aVar.Uc == null)) {
                alertController.a(-3, aVar.Ub, aVar.Ud, null, aVar.Uc);
            }
            if (!(aVar.Uh == null && aVar.PI == null && aVar.Ei == null)) {
                ListAdapter listAdapter;
                RecycleListView recycleListView = (RecycleListView) aVar.mInflater.inflate(alertController.TK, null);
                Object listAdapter2;
                if (!aVar.Uk) {
                    int i2;
                    if (aVar.Ul) {
                        i2 = alertController.TM;
                    } else {
                        i2 = alertController.TN;
                    }
                    if (aVar.PI != null) {
                        listAdapter2 = new SimpleCursorAdapter(aVar.mContext, i2, aVar.PI, new String[]{aVar.Un}, new int[]{16908308});
                    } else if (aVar.Ei != null) {
                        listAdapter2 = aVar.Ei;
                    } else {
                        listAdapter2 = new c(aVar.mContext, i2, aVar.Uh);
                    }
                } else if (aVar.PI == null) {
                    listAdapter2 = new AnonymousClass1(aVar.mContext, alertController.TL, aVar.Uh, recycleListView);
                } else {
                    listAdapter2 = new AnonymousClass2(aVar.mContext, aVar.PI, recycleListView, alertController);
                }
                alertController.Ei = listAdapter2;
                alertController.TH = aVar.TH;
                if (aVar.Ui != null) {
                    recycleListView.setOnItemClickListener(new AnonymousClass3(alertController));
                } else if (aVar.Um != null) {
                    recycleListView.setOnItemClickListener(new AnonymousClass4(recycleListView, alertController));
                }
                if (aVar.Up != null) {
                    recycleListView.setOnItemSelectedListener(aVar.Up);
                }
                if (aVar.Ul) {
                    recycleListView.setChoiceMode(1);
                } else if (aVar.Uk) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.mListView = recycleListView;
            }
            if (aVar.mView != null) {
                if (aVar.Tq) {
                    View view = aVar.mView;
                    int i3 = aVar.Tm;
                    int i4 = aVar.Tn;
                    int i5 = aVar.To;
                    int i6 = aVar.Tp;
                    alertController.mView = view;
                    alertController.Tl = 0;
                    alertController.Tq = true;
                    alertController.Tm = i3;
                    alertController.Tn = i4;
                    alertController.To = i5;
                    alertController.Tp = i6;
                } else {
                    alertController.mView = aVar.mView;
                    alertController.Tl = 0;
                    alertController.Tq = false;
                }
            } else if (aVar.Tl != 0) {
                i = aVar.Tl;
                alertController.mView = null;
                alertController.Tl = i;
                alertController.Tq = false;
            }
            bVar.setCancelable(this.UA.mCancelable);
            if (this.UA.mCancelable) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.UA.Ue);
            bVar.setOnDismissListener(this.UA.Uf);
            if (this.UA.Ug != null) {
                bVar.setOnKeyListener(this.UA.Ug);
            }
            return bVar;
        }
    }

    protected b(Context context, int i) {
        super(context, j(context, i));
    }

    static int j(Context context, int i) {
        if (((i >>> 24) & 255) > 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.fy, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Uz.setTitle(charSequence);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        int i;
        View view;
        int indexOfChild;
        Object obj;
        int i2;
        super.onCreate(bundle);
        AlertController alertController = this.Uz;
        if (alertController.TJ == 0 || alertController.TP != 1) {
            i = alertController.TI;
        } else {
            i = alertController.TJ;
        }
        alertController.Th.setContentView(i);
        View findViewById = alertController.Ti.findViewById(R.id.je);
        View findViewById2 = findViewById.findViewById(R.id.jn);
        View findViewById3 = findViewById.findViewById(R.id.jf);
        View findViewById4 = findViewById.findViewById(R.id.jc);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(R.id.jl);
        if (alertController.mView != null) {
            view = alertController.mView;
        } else if (alertController.Tl != 0) {
            view = LayoutInflater.from(alertController.mContext).inflate(alertController.Tl, viewGroup, false);
        } else {
            view = null;
        }
        Object obj2 = view != null ? 1 : null;
        if (obj2 == null || !AlertController.aQ(view)) {
            alertController.Ti.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (obj2 != null) {
            FrameLayout frameLayout = (FrameLayout) alertController.Ti.findViewById(R.id.jm);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            if (alertController.Tq) {
                frameLayout.setPadding(alertController.Tm, alertController.Tn, alertController.To, alertController.Tp);
            }
            if (alertController.mListView != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(R.id.jn);
        view = viewGroup.findViewById(R.id.jf);
        View findViewById6 = viewGroup.findViewById(R.id.jc);
        ViewGroup c = AlertController.c(findViewById5, findViewById2);
        ViewGroup c2 = AlertController.c(view, findViewById3);
        ViewGroup c3 = AlertController.c(findViewById6, findViewById4);
        alertController.TD = (NestedScrollView) alertController.Ti.findViewById(R.id.jh);
        alertController.TD.setFocusable(false);
        alertController.TD.setNestedScrollingEnabled(false);
        alertController.ma = (TextView) c2.findViewById(16908299);
        if (alertController.ma != null) {
            if (alertController.Tk != null) {
                alertController.ma.setText(alertController.Tk);
            } else {
                alertController.ma.setVisibility(8);
                alertController.TD.removeView(alertController.ma);
                if (alertController.mListView != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.TD.getParent();
                    indexOfChild = viewGroup2.indexOfChild(alertController.TD);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.mListView, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    c2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        alertController.Tr = (Button) c3.findViewById(16908313);
        alertController.Tr.setOnClickListener(alertController.TQ);
        if (TextUtils.isEmpty(alertController.Ts) && alertController.Tu == null) {
            alertController.Tr.setVisibility(8);
        } else {
            alertController.Tr.setText(alertController.Ts);
            if (alertController.Tu != null) {
                alertController.Tu.setBounds(0, 0, alertController.Tj, alertController.Tj);
                alertController.Tr.setCompoundDrawables(alertController.Tu, null, null, null);
            }
            alertController.Tr.setVisibility(0);
            indexOfChild = 1;
        }
        alertController.Tv = (Button) c3.findViewById(16908314);
        alertController.Tv.setOnClickListener(alertController.TQ);
        if (TextUtils.isEmpty(alertController.Tw) && alertController.Ty == null) {
            alertController.Tv.setVisibility(8);
        } else {
            alertController.Tv.setText(alertController.Tw);
            if (alertController.Ty != null) {
                alertController.Ty.setBounds(0, 0, alertController.Tj, alertController.Tj);
                alertController.Tv.setCompoundDrawables(alertController.Ty, null, null, null);
            }
            alertController.Tv.setVisibility(0);
            indexOfChild |= 2;
        }
        alertController.Tz = (Button) c3.findViewById(16908315);
        alertController.Tz.setOnClickListener(alertController.TQ);
        if (TextUtils.isEmpty(alertController.TA) && alertController.TC == null) {
            alertController.Tz.setVisibility(8);
        } else {
            alertController.Tz.setText(alertController.TA);
            if (alertController.Tu != null) {
                alertController.Tu.setBounds(0, 0, alertController.Tj, alertController.Tj);
                alertController.Tr.setCompoundDrawables(alertController.Tu, null, null, null);
            }
            alertController.Tz.setVisibility(0);
            indexOfChild |= 4;
        }
        Context context = alertController.mContext;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.fx, typedValue, true);
        if (typedValue.data != 0) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (indexOfChild == 1) {
                AlertController.a(alertController.Tr);
            } else if (indexOfChild == 2) {
                AlertController.a(alertController.Tv);
            } else if (indexOfChild == 4) {
                AlertController.a(alertController.Tz);
            }
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            c3.setVisibility(8);
        }
        if (alertController.TG != null) {
            c.addView(alertController.TG, 0, new LayoutParams(-1, -2));
            alertController.Ti.findViewById(R.id.jo).setVisibility(8);
        } else {
            alertController.sX = (ImageView) alertController.Ti.findViewById(16908294);
            if ((!TextUtils.isEmpty(alertController.IT) ? 1 : null) == null || !alertController.TO) {
                alertController.Ti.findViewById(R.id.jo).setVisibility(8);
                alertController.sX.setVisibility(8);
                c.setVisibility(8);
            } else {
                alertController.TF = (TextView) alertController.Ti.findViewById(R.id.jp);
                alertController.TF.setText(alertController.IT);
                if (alertController.TE != 0) {
                    alertController.sX.setImageResource(alertController.TE);
                } else if (alertController.rP != null) {
                    alertController.sX.setImageDrawable(alertController.rP);
                } else {
                    alertController.TF.setPadding(alertController.sX.getPaddingLeft(), alertController.sX.getPaddingTop(), alertController.sX.getPaddingRight(), alertController.sX.getPaddingBottom());
                    alertController.sX.setVisibility(8);
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
            findViewById = c2.findViewById(R.id.jj);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (obj4 != null) {
            if (alertController.TD != null) {
                alertController.TD.setClipToPadding(true);
            }
            findViewById = null;
            if (!(alertController.Tk == null && alertController.mListView == null)) {
                findViewById = c.findViewById(R.id.jq);
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        } else if (c2 != null) {
            findViewById = c2.findViewById(R.id.ji);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (alertController.mListView instanceof RecycleListView) {
            RecycleListView recycleListView = (RecycleListView) alertController.mListView;
            if (obj == null || obj4 == null) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), obj4 != null ? recycleListView.getPaddingTop() : recycleListView.Ux, recycleListView.getPaddingRight(), obj != null ? recycleListView.getPaddingBottom() : recycleListView.Uy);
            }
        }
        if (obj3 == null) {
            view = alertController.mListView != null ? alertController.mListView : alertController.TD;
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
                findViewById5 = alertController.Ti.findViewById(R.id.jg);
                findViewById = alertController.Ti.findViewById(R.id.jk);
                if (VERSION.SDK_INT >= 23) {
                    s.s(view, i3);
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
                        if (alertController.Tk != null) {
                            alertController.TD.setOnScrollChangeListener(new AlertController.AnonymousClass2(findViewById5, findViewById));
                            alertController.TD.post(new AlertController.AnonymousClass3(findViewById5, findViewById));
                        } else if (alertController.mListView != null) {
                            alertController.mListView.setOnScrollListener(new AlertController.AnonymousClass4(findViewById5, findViewById));
                            alertController.mListView.post(new AnonymousClass5(findViewById5, findViewById));
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
        if (listView != null && alertController.Ei != null) {
            listView.setAdapter(alertController.Ei);
            i2 = alertController.TH;
            if (i2 >= 0) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        AlertController alertController = this.Uz;
        if (alertController.TD == null || !alertController.TD.executeKeyEvent(keyEvent)) {
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
        AlertController alertController = this.Uz;
        if (alertController.TD == null || !alertController.TD.executeKeyEvent(keyEvent)) {
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
