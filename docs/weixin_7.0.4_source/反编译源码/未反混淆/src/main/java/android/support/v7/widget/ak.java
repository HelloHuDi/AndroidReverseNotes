package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class ak extends ListPopupWindow implements aj {
    private static Method amJ;
    public aj amK;

    public static class a extends ab {
        private aj amK;
        final int amL;
        final int amM;
        private MenuItem amN;

        public final /* bridge */ /* synthetic */ boolean b(MotionEvent motionEvent, int i) {
            return super.b(motionEvent, i);
        }

        public final /* bridge */ /* synthetic */ int d(int i, int i2, int i3, int i4, int i5) {
            return super.d(i, i2, i3, i4, i5);
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

        public a(Context context, boolean z) {
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

        public final void setHoverListener(aj ajVar) {
            this.amK = ajVar;
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
                ((g) getAdapter()).abn.U(false);
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.amK != null) {
                int headersCount;
                g gVar;
                MenuItem br;
                MenuItem menuItem;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    gVar = (g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    gVar = (g) adapter;
                }
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        headersCount = pointToPosition - headersCount;
                        if (headersCount >= 0 && headersCount < gVar.getCount()) {
                            br = gVar.getItem(headersCount);
                            menuItem = this.amN;
                            if (menuItem != br) {
                                h hVar = gVar.abn;
                                if (menuItem != null) {
                                    this.amK.b(hVar, menuItem);
                                }
                                this.amN = br;
                                if (br != null) {
                                    this.amK.c(hVar, br);
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

    public ak(Context context, int i, int i2) {
        super(context, null, i, i2);
    }

    /* Access modifiers changed, original: final */
    public final ab g(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public final void jb() {
        if (VERSION.SDK_INT >= 23) {
            this.amH.setEnterTransition(null);
        }
    }

    public final void jc() {
        if (amJ != null) {
            try {
                amJ.invoke(this.amH, new Object[]{Boolean.FALSE});
            } catch (Exception e) {
            }
        }
    }

    public final void c(h hVar, MenuItem menuItem) {
        if (this.amK != null) {
            this.amK.c(hVar, menuItem);
        }
    }

    public final void b(h hVar, MenuItem menuItem) {
        if (this.amK != null) {
            this.amK.b(hVar, menuItem);
        }
    }
}
