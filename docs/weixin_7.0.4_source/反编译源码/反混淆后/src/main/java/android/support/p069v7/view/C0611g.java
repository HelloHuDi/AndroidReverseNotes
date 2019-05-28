package android.support.p069v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.p057v4.p060b.p061a.C0368a;
import android.support.p057v4.p060b.p061a.C0369b;
import android.support.p057v4.view.C0455b;
import android.support.p057v4.view.C0464g;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.view.menu.C7455k;
import android.support.p069v7.widget.C0679aa;
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

/* renamed from: android.support.v7.view.g */
public final class C0611g extends MenuInflater {
    /* renamed from: YU */
    static final Class<?>[] f982YU;
    /* renamed from: YV */
    static final Class<?>[] f983YV;
    /* renamed from: YW */
    final Object[] f984YW;
    /* renamed from: YX */
    final Object[] f985YX = this.f984YW;
    /* renamed from: YY */
    Object f986YY;
    Context mContext;

    /* renamed from: android.support.v7.view.g$a */
    static class C0609a implements OnMenuItemClickListener {
        /* renamed from: YZ */
        private static final Class<?>[] f948YZ = new Class[]{MenuItem.class};
        /* renamed from: YY */
        private Object f949YY;
        private Method mMethod;

        public C0609a(Object obj, String str) {
            this.f949YY = obj;
            Class cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, f948YZ);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.mMethod.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.mMethod.invoke(this.f949YY, new Object[]{menuItem})).booleanValue();
                }
                this.mMethod.invoke(this.f949YY, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: android.support.v7.view.g$b */
    class C0610b {
        /* renamed from: ZA */
        C0455b f950ZA;
        /* renamed from: ZB */
        private CharSequence f951ZB;
        /* renamed from: ZC */
        private CharSequence f952ZC;
        /* renamed from: ZD */
        private ColorStateList f953ZD = null;
        /* renamed from: ZE */
        private Mode f954ZE = null;
        /* renamed from: Za */
        private Menu f956Za;
        /* renamed from: Zb */
        private int f957Zb;
        /* renamed from: Zc */
        private int f958Zc;
        /* renamed from: Zd */
        private int f959Zd;
        /* renamed from: Ze */
        private int f960Ze;
        /* renamed from: Zf */
        private boolean f961Zf;
        /* renamed from: Zg */
        private boolean f962Zg;
        /* renamed from: Zh */
        boolean f963Zh;
        /* renamed from: Zi */
        private int f964Zi;
        /* renamed from: Zj */
        private int f965Zj;
        /* renamed from: Zk */
        private CharSequence f966Zk;
        /* renamed from: Zl */
        private CharSequence f967Zl;
        /* renamed from: Zm */
        private int f968Zm;
        /* renamed from: Zn */
        private char f969Zn;
        /* renamed from: Zo */
        private int f970Zo;
        /* renamed from: Zp */
        private char f971Zp;
        /* renamed from: Zq */
        private int f972Zq;
        /* renamed from: Zr */
        private int f973Zr;
        /* renamed from: Zs */
        private boolean f974Zs;
        /* renamed from: Zt */
        private boolean f975Zt;
        /* renamed from: Zu */
        private boolean f976Zu;
        /* renamed from: Zv */
        private int f977Zv;
        /* renamed from: Zw */
        private int f978Zw;
        /* renamed from: Zx */
        private String f979Zx;
        /* renamed from: Zy */
        private String f980Zy;
        /* renamed from: Zz */
        private String f981Zz;

        public C0610b(Menu menu) {
            this.f956Za = menu;
            mo1531gd();
        }

        /* renamed from: gd */
        public final void mo1531gd() {
            this.f957Zb = 0;
            this.f958Zc = 0;
            this.f959Zd = 0;
            this.f960Ze = 0;
            this.f961Zf = true;
            this.f962Zg = true;
        }

        /* renamed from: d */
        public final void mo1529d(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = C0611g.this.mContext.obtainStyledAttributes(attributeSet, C0554a.MenuGroup);
            this.f957Zb = obtainStyledAttributes.getResourceId(1, 0);
            this.f958Zc = obtainStyledAttributes.getInt(3, 0);
            this.f959Zd = obtainStyledAttributes.getInt(4, 0);
            this.f960Ze = obtainStyledAttributes.getInt(5, 0);
            this.f961Zf = obtainStyledAttributes.getBoolean(2, true);
            this.f962Zg = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: e */
        public final void mo1530e(AttributeSet attributeSet) {
            int i = 1;
            TypedArray obtainStyledAttributes = C0611g.this.mContext.obtainStyledAttributes(attributeSet, C0554a.MenuItem);
            this.f964Zi = obtainStyledAttributes.getResourceId(2, 0);
            this.f965Zj = (obtainStyledAttributes.getInt(5, this.f958Zc) & -65536) | (obtainStyledAttributes.getInt(6, this.f959Zd) & CdnLogic.kBizGeneric);
            this.f966Zk = obtainStyledAttributes.getText(7);
            this.f967Zl = obtainStyledAttributes.getText(8);
            this.f968Zm = obtainStyledAttributes.getResourceId(0, 0);
            this.f969Zn = C0610b.m1318Q(obtainStyledAttributes.getString(9));
            this.f970Zo = obtainStyledAttributes.getInt(13, 4096);
            this.f971Zp = C0610b.m1318Q(obtainStyledAttributes.getString(10));
            this.f972Zq = obtainStyledAttributes.getInt(14, 4096);
            if (obtainStyledAttributes.hasValue(11)) {
                this.f973Zr = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
            } else {
                this.f973Zr = this.f960Ze;
            }
            this.f974Zs = obtainStyledAttributes.getBoolean(3, false);
            this.f975Zt = obtainStyledAttributes.getBoolean(4, this.f961Zf);
            this.f976Zu = obtainStyledAttributes.getBoolean(1, this.f962Zg);
            this.f977Zv = obtainStyledAttributes.getInt(15, -1);
            this.f981Zz = obtainStyledAttributes.getString(12);
            this.f978Zw = obtainStyledAttributes.getResourceId(16, 0);
            this.f979Zx = obtainStyledAttributes.getString(17);
            this.f980Zy = obtainStyledAttributes.getString(18);
            if (this.f980Zy == null) {
                i = 0;
            }
            if (i != 0 && this.f978Zw == 0 && this.f979Zx == null) {
                this.f950ZA = (C0455b) newInstance(this.f980Zy, C0611g.f983YV, C0611g.this.f985YX);
            } else {
                this.f950ZA = null;
            }
            this.f951ZB = obtainStyledAttributes.getText(19);
            this.f952ZC = obtainStyledAttributes.getText(20);
            if (obtainStyledAttributes.hasValue(22)) {
                this.f954ZE = C0679aa.m1528d(obtainStyledAttributes.getInt(22, -1), this.f954ZE);
            } else {
                this.f954ZE = null;
            }
            if (obtainStyledAttributes.hasValue(21)) {
                this.f953ZD = obtainStyledAttributes.getColorStateList(21);
            } else {
                this.f953ZD = null;
            }
            obtainStyledAttributes.recycle();
            this.f963Zh = false;
        }

        /* renamed from: Q */
        private static char m1318Q(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        /* renamed from: d */
        private void m1319d(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f974Zs).setVisible(this.f975Zt).setEnabled(this.f976Zu).setCheckable(this.f973Zr > 0).setTitleCondensed(this.f967Zl).setIcon(this.f968Zm);
            if (this.f977Zv >= 0) {
                menuItem.setShowAsAction(this.f977Zv);
            }
            if (this.f981Zz != null) {
                if (C0611g.this.mContext.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                C0611g c0611g = C0611g.this;
                if (c0611g.f986YY == null) {
                    c0611g.f986YY = C0611g.m1325N(c0611g.mContext);
                }
                menuItem.setOnMenuItemClickListener(new C0609a(c0611g.f986YY, this.f981Zz));
            }
            if (this.f973Zr >= 2) {
                if (menuItem instanceof C6239j) {
                    ((C6239j) menuItem).mo14165V(true);
                } else if (menuItem instanceof C7455k) {
                    C7455k c7455k = (C7455k) menuItem;
                    try {
                        if (c7455k.acb == null) {
                            c7455k.acb = ((C0369b) c7455k.aar).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        c7455k.acb.invoke(c7455k.aar, new Object[]{Boolean.TRUE});
                    } catch (Exception e) {
                    }
                }
            }
            if (this.f979Zx != null) {
                menuItem.setActionView((View) newInstance(this.f979Zx, C0611g.f982YU, C0611g.this.f984YW));
            } else {
                z = false;
            }
            if (this.f978Zw > 0 && !z) {
                menuItem.setActionView(this.f978Zw);
            }
            if (this.f950ZA != null) {
                C0464g.m801a(menuItem, this.f950ZA);
            }
            C0464g.m809a(menuItem, this.f951ZB);
            C0464g.m811b(menuItem, this.f952ZC);
            C0464g.m810b(menuItem, this.f969Zn, this.f970Zo);
            C0464g.m805a(menuItem, this.f971Zp, this.f972Zq);
            if (this.f954ZE != null) {
                C0464g.m808a(menuItem, this.f954ZE);
            }
            if (this.f953ZD != null) {
                C0464g.m807a(menuItem, this.f953ZD);
            }
        }

        /* renamed from: ge */
        public final void mo1532ge() {
            this.f963Zh = true;
            m1319d(this.f956Za.add(this.f957Zb, this.f964Zi, this.f965Zj, this.f966Zk));
        }

        /* renamed from: gf */
        public final SubMenu mo1533gf() {
            this.f963Zh = true;
            SubMenu addSubMenu = this.f956Za.addSubMenu(this.f957Zb, this.f964Zi, this.f965Zj, this.f966Zk);
            m1319d(addSubMenu.getItem());
            return addSubMenu;
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = C0611g.this.mContext.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                return null;
            }
        }
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        f982YU = clsArr;
        f983YV = clsArr;
    }

    public C0611g(Context context) {
        super(context);
        this.mContext = context;
        this.f984YW = new Object[]{context};
    }

    public final void inflate(int i, Menu menu) {
        if (menu instanceof C0368a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.mContext.getResources().getLayout(i);
                m1326a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
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
    /* renamed from: a */
    private void m1326a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        C0610b c0610b = new C0610b(menu);
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
                                    m1326a(xmlPullParser, attributeSet, c0610b.mo1533gf());
                                    obj4 = obj;
                                    break;
                                }
                                c0610b.mo1530e(attributeSet);
                                obj4 = obj;
                                break;
                            }
                            c0610b.mo1529d(attributeSet);
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
                                } else if (!c0610b.f963Zh) {
                                    if (c0610b.f950ZA != null && c0610b.f950ZA.hasSubMenu()) {
                                        c0610b.mo1533gf();
                                        obj4 = obj;
                                        break;
                                    }
                                    c0610b.mo1532ge();
                                    obj4 = obj;
                                    break;
                                }
                            }
                            c0610b.mo1531gd();
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

    /* renamed from: N */
    static Object m1325N(Object obj) {
        Object obj2 = obj;
        while (!(obj2 instanceof Activity) && (obj2 instanceof ContextWrapper)) {
            obj2 = ((ContextWrapper) obj2).getBaseContext();
        }
        return obj2;
    }
}
