package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p069v7.view.menu.C0622g;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.ListMenuItemView;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.ak */
public final class C7461ak extends ListPopupWindow implements C0688aj {
    private static Method amJ;
    public C0688aj amK;

    /* renamed from: android.support.v7.widget.ak$a */
    public static class C6254a extends C0681ab {
        private C0688aj amK;
        final int amL;
        final int amM;
        private MenuItem amN;

        /* renamed from: b */
        public final /* bridge */ /* synthetic */ boolean mo1931b(MotionEvent motionEvent, int i) {
            return super.mo1931b(motionEvent, i);
        }

        /* renamed from: d */
        public final /* bridge */ /* synthetic */ int mo1932d(int i, int i2, int i3, int i4, int i5) {
            return super.mo1932d(i, i2, i3, i4, i5);
        }

        public final /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public final /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public final /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public final /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public final /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public final /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public C6254a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.amL = 22;
                this.amM = 21;
                return;
            }
            this.amL = 21;
            this.amM = 22;
        }

        public final void setHoverListener(C0688aj c0688aj) {
            this.amK = c0688aj;
        }

        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.amL) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.amM) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0622g) getAdapter()).abn.mo14110U(false);
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.amK != null) {
                int headersCount;
                C0622g c0622g;
                MenuItem br;
                MenuItem menuItem;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    c0622g = (C0622g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    c0622g = (C0622g) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < c0622g.getCount()) {
                            br = c0622g.getItem(headersCount);
                            menuItem = this.amN;
                            if (menuItem != br) {
                                C6236h c6236h = c0622g.abn;
                                if (menuItem != null) {
                                    this.amK.mo1955b(c6236h, menuItem);
                                }
                                this.amN = br;
                                if (br != null) {
                                    this.amK.mo1956c(c6236h, br);
                                }
                            }
                        }
                    }
                }
                br = null;
                menuItem = this.amN;
                if (menuItem != br) {
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
        try {
            amJ = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
    }

    public C7461ak(Context context, int i, int i2) {
        super(context, null, i, i2);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final C0681ab mo14388g(Context context, boolean z) {
        C6254a c6254a = new C6254a(context, z);
        c6254a.setHoverListener(this);
        return c6254a;
    }

    /* renamed from: jb */
    public final void mo16484jb() {
        if (VERSION.SDK_INT >= 23) {
            this.amH.setEnterTransition(null);
        }
    }

    /* renamed from: jc */
    public final void mo16485jc() {
        if (amJ != null) {
            try {
                amJ.invoke(this.amH, new Object[]{Boolean.FALSE});
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: c */
    public final void mo1956c(C6236h c6236h, MenuItem menuItem) {
        if (this.amK != null) {
            this.amK.mo1956c(c6236h, menuItem);
        }
    }

    /* renamed from: b */
    public final void mo1955b(C6236h c6236h, MenuItem menuItem) {
        if (this.amK != null) {
            this.amK.mo1955b(c6236h, menuItem);
        }
    }
}
