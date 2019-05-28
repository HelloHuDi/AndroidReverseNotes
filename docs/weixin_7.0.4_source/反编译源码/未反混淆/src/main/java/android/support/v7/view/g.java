package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.aa;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mars.cdn.CdnLogic;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class g extends MenuInflater {
    static final Class<?>[] YU;
    static final Class<?>[] YV;
    final Object[] YW;
    final Object[] YX = this.YW;
    Object YY;
    Context mContext;

    static class a implements OnMenuItemClickListener {
        private static final Class<?>[] YZ = new Class[]{MenuItem.class};
        private Object YY;
        private Method mMethod;

        public a(Object obj, String str) {
            this.YY = obj;
            Class cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, YZ);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.YY, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.YY, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    class b {
        android.support.v4.view.b ZA;
        private CharSequence ZB;
        private CharSequence ZC;
        private ColorStateList ZD = null;
        private Mode ZE = null;
        private Menu Za;
        private int Zb;
        private int Zc;
        private int Zd;
        private int Ze;
        private boolean Zf;
        private boolean Zg;
        boolean Zh;
        private int Zi;
        private int Zj;
        private CharSequence Zk;
        private CharSequence Zl;
        private int Zm;
        private char Zn;
        private int Zo;
        private char Zp;
        private int Zq;
        private int Zr;
        private boolean Zs;
        private boolean Zt;
        private boolean Zu;
        private int Zv;
        private int Zw;
        private String Zx;
        private String Zy;
        private String Zz;

        public b(Menu menu) {
            this.Za = menu;
            gd();
        }

        public final void gd() {
            this.Zb = 0;
            this.Zc = 0;
            this.Zd = 0;
            this.Ze = 0;
            this.Zf = true;
            this.Zg = true;
        }

        public final void d(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, android.support.v7.a.a.a.MenuGroup);
            this.Zb = obtainStyledAttributes.getResourceId(1, 0);
            this.Zc = obtainStyledAttributes.getInt(3, 0);
            this.Zd = obtainStyledAttributes.getInt(4, 0);
            this.Ze = obtainStyledAttributes.getInt(5, 0);
            this.Zf = obtainStyledAttributes.getBoolean(2, true);
            this.Zg = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public final void e(AttributeSet attributeSet) {
            int i = 1;
            TypedArray obtainStyledAttributes = g.this.mContext.obtainStyledAttributes(attributeSet, android.support.v7.a.a.a.MenuItem);
            this.Zi = obtainStyledAttributes.getResourceId(2, 0);
            this.Zj = (obtainStyledAttributes.getInt(5, this.Zc) & -65536) | (obtainStyledAttributes.getInt(6, this.Zd) & CdnLogic.kBizGeneric);
            this.Zk = obtainStyledAttributes.getText(7);
            this.Zl = obtainStyledAttributes.getText(8);
            this.Zm = obtainStyledAttributes.getResourceId(0, 0);
            this.Zn = Q(obtainStyledAttributes.getString(9));
            this.Zo = obtainStyledAttributes.getInt(13, 4096);
            this.Zp = Q(obtainStyledAttributes.getString(10));
            this.Zq = obtainStyledAttributes.getInt(14, 4096);
            if (obtainStyledAttributes.hasValue(11)) {
                this.Zr = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
            } else {
                this.Zr = this.Ze;
            }
            this.Zs = obtainStyledAttributes.getBoolean(3, false);
            this.Zt = obtainStyledAttributes.getBoolean(4, this.Zf);
            this.Zu = obtainStyledAttributes.getBoolean(1, this.Zg);
            this.Zv = obtainStyledAttributes.getInt(15, -1);
            this.Zz = obtainStyledAttributes.getString(12);
            this.Zw = obtainStyledAttributes.getResourceId(16, 0);
            this.Zx = obtainStyledAttributes.getString(17);
            this.Zy = obtainStyledAttributes.getString(18);
            if (this.Zy == null) {
                i = 0;
            }
            if (i != 0 && this.Zw == 0 && this.Zx == null) {
                this.ZA = (android.support.v4.view.b) newInstance(this.Zy, g.YV, g.this.YX);
            } else {
                this.ZA = null;
            }
            this.ZB = obtainStyledAttributes.getText(19);
            this.ZC = obtainStyledAttributes.getText(20);
            if (obtainStyledAttributes.hasValue(22)) {
                this.ZE = aa.d(obtainStyledAttributes.getInt(22, -1), this.ZE);
            } else {
                this.ZE = null;
            }
            if (obtainStyledAttributes.hasValue(21)) {
                this.ZD = obtainStyledAttributes.getColorStateList(21);
            } else {
                this.ZD = null;
            }
            obtainStyledAttributes.recycle();
            this.Zh = false;
        }

        private static char Q(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private void d(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.Zs).setVisible(this.Zt).setEnabled(this.Zu).setCheckable(this.Zr > 0).setTitleCondensed(this.Zl).setIcon(this.Zm);
            if (this.Zv >= 0) {
                menuItem.setShowAsAction(this.Zv);
            }
            if (this.Zz != null) {
                if (g.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                g gVar = g.this;
                if (gVar.YY == null) {
                    gVar.YY = g.N(gVar.mContext);
                }
                menuItem.setOnMenuItemClickListener(new a(gVar.YY, this.Zz));
            }
            if (this.Zr >= 2) {
                if (menuItem instanceof j) {
                    ((j) menuItem).V(true);
                } else if (menuItem instanceof k) {
                    k kVar = (k) menuItem;
                    try {
                        if (kVar.acb == null) {
                            kVar.acb = ((android.support.v4.b.a.b) kVar.aar).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        kVar.acb.invoke(kVar.aar, new Object[]{Boolean.TRUE});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.Zx != null) {
                menuItem.setActionView((View) newInstance(this.Zx, g.YU, g.this.YW));
            } else {
                z = false;
            }
            if (this.Zw > 0 && !z) {
                menuItem.setActionView(this.Zw);
            }
            if (this.ZA != null) {
                android.support.v4.view.g.a(menuItem, this.ZA);
            }
            android.support.v4.view.g.a(menuItem, this.ZB);
            android.support.v4.view.g.b(menuItem, this.ZC);
            android.support.v4.view.g.b(menuItem, this.Zn, this.Zo);
            android.support.v4.view.g.a(menuItem, this.Zp, this.Zq);
            if (this.ZE != null) {
                android.support.v4.view.g.a(menuItem, this.ZE);
            }
            if (this.ZD != null) {
                android.support.v4.view.g.a(menuItem, this.ZD);
            }
        }

        public final void ge() {
            this.Zh = true;
            d(this.Za.add(this.Zb, this.Zi, this.Zj, this.Zk));
        }

        public final SubMenu gf() {
            this.Zh = true;
            SubMenu addSubMenu = this.Za.addSubMenu(this.Zb, this.Zi, this.Zj, this.Zk);
            d(addSubMenu.getItem());
            return addSubMenu;
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        YU = clsArr;
        YV = clsArr;
    }

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.YW = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof android.support.v4.b.a.a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (XmlPullParserException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                break;
            }
        }
        String name = xmlPullParser.getName();
        if (name.equals("menu")) {
            eventType = xmlPullParser.next();
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            int i = eventType;
            while (obj == null) {
                Object obj4;
                switch (i) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (obj3 == null) {
                            String name2 = xmlPullParser.getName();
                            if (!name2.equals("group")) {
                                if (!name2.equals("item")) {
                                    if (!name2.equals("menu")) {
                                        obj4 = obj;
                                        String obj22 = name2;
                                        int obj32 = 1;
                                        break;
                                    }
                                    a(xmlPullParser, attributeSet, bVar.gf());
                                    obj4 = obj;
                                    break;
                                }
                                bVar.e(attributeSet);
                                obj4 = obj;
                                break;
                            }
                            bVar.d(attributeSet);
                            obj4 = obj;
                            break;
                        }
                    case 3:
                        name = xmlPullParser.getName();
                        if (obj32 == null || !name.equals(obj22)) {
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (name.equals("menu")) {
                                        eventType = 1;
                                        break;
                                    }
                                } else if (!bVar.Zh) {
                                    if (bVar.ZA != null && bVar.ZA.hasSubMenu()) {
                                        bVar.gf();
                                        obj4 = obj;
                                        break;
                                    }
                                    bVar.ge();
                                    obj4 = obj;
                                    break;
                                }
                            }
                            bVar.gd();
                            obj4 = obj;
                            break;
                        }
                        obj4 = obj;
                        obj22 = null;
                        obj32 = null;
                        break;
                        break;
                    default:
                        obj4 = obj;
                        break;
                }
                i = xmlPullParser.next();
                obj = obj4;
            }
            return;
        }
        throw new RuntimeException("Expecting menu, got ".concat(String.valueOf(name)));
    }

    static Object N(Object obj) {
        Object obj2 = obj;
        while (!(obj2 instanceof Activity) && (obj2 instanceof ContextWrapper)) {
            obj2 = ((ContextWrapper) obj2).getBaseContext();
        }
        return obj2;
    }
}
