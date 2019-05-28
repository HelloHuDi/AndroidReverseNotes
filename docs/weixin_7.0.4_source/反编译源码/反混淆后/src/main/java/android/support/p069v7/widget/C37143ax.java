package android.support.p069v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.widget.C31871o;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.C25738R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.ax */
final class C37143ax extends C31871o implements OnClickListener {
    private final SearchView arD;
    private final SearchableInfo aro;
    private final WeakHashMap<String, ConstantState> art;
    private final Context asA;
    private final int asB;
    int asC = 1;
    private ColorStateList asD;
    private int asE = -1;
    private int asF = -1;
    private int asG = -1;
    private int asH = -1;
    private int asI = -1;
    private int asJ = -1;
    private final SearchManager asz = ((SearchManager) this.mContext.getSystemService(C8740a.SEARCH));
    private boolean mClosed = false;

    /* renamed from: android.support.v7.widget.ax$a */
    static final class C37142a {
        public final TextView asK;
        public final TextView asL;
        public final ImageView asM;
        public final ImageView asN;
        public final ImageView asO;

        public C37142a(View view) {
            this.asK = (TextView) view.findViewById(16908308);
            this.asL = (TextView) view.findViewById(16908309);
            this.asM = (ImageView) view.findViewById(16908295);
            this.asN = (ImageView) view.findViewById(16908296);
            this.asO = (ImageView) view.findViewById(2131820943);
        }
    }

    public C37143ax(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.arD = searchView;
        this.aro = searchableInfo;
        this.asB = searchView.getSuggestionCommitIconResId();
        this.asA = context;
        this.art = weakHashMap;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.arD.getVisibility() != 0 || this.arD.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor;
            SearchableInfo searchableInfo = this.aro;
            if (searchableInfo == null) {
                cursor = null;
            } else {
                String suggestAuthority = searchableInfo.getSuggestAuthority();
                if (suggestAuthority == null) {
                    cursor = null;
                } else {
                    String[] strArr;
                    Builder fragment = new Builder().scheme(C8741b.CONTENT).authority(suggestAuthority).query("").fragment("");
                    String suggestPath = searchableInfo.getSuggestPath();
                    if (suggestPath != null) {
                        fragment.appendEncodedPath(suggestPath);
                    }
                    fragment.appendPath("search_suggest_query");
                    suggestPath = searchableInfo.getSuggestSelection();
                    if (suggestPath != null) {
                        strArr = new String[]{charSequence2};
                    } else {
                        fragment.appendPath(charSequence2);
                        strArr = null;
                    }
                    fragment.appendQueryParameter("limit", "50");
                    cursor = this.mContext.getContentResolver().query(fragment.build(), null, suggestPath, strArr, null);
                }
            }
            if (cursor != null) {
                cursor.getCount();
                return cursor;
            }
        } catch (RuntimeException e) {
        }
        return null;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        C37143ax.m62178c(getCursor());
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        C37143ax.m62178c(getCursor());
    }

    /* renamed from: c */
    private static void m62178c(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public final void changeCursor(Cursor cursor) {
        if (!this.mClosed) {
            try {
                super.changeCursor(cursor);
                if (cursor != null) {
                    this.asE = cursor.getColumnIndex("suggest_text_1");
                    this.asF = cursor.getColumnIndex("suggest_text_2");
                    this.asG = cursor.getColumnIndex("suggest_text_2_url");
                    this.asH = cursor.getColumnIndex("suggest_icon_1");
                    this.asI = cursor.getColumnIndex("suggest_icon_2");
                    this.asJ = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception e) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new C37142a(newView));
        ((ImageView) newView.findViewById(2131820943)).setImageResource(this.asB);
        return newView;
    }

    /* renamed from: a */
    public final void mo59211a(View view, Cursor cursor) {
        Drawable drawable = null;
        C37142a c37142a = (C37142a) view.getTag();
        int i;
        if (this.asJ != -1) {
            i = cursor.getInt(this.asJ);
        } else {
            i = 0;
        }
        if (c37142a.asK != null) {
            C37143ax.m62176a(c37142a.asK, C37143ax.m62173a(cursor, this.asE));
        }
        if (c37142a.asL != null) {
            CharSequence charSequence;
            String a = C37143ax.m62173a(cursor, this.asG);
            if (a != null) {
                if (this.asD == null) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(C25738R.attr.f5664f6, typedValue, true);
                    this.asD = this.mContext.getResources().getColorStateList(typedValue.resourceId);
                }
                CharSequence spannableString = new SpannableString(a);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.asD, null), 0, a.length(), 33);
                charSequence = spannableString;
            } else {
                charSequence = C37143ax.m62173a(cursor, this.asF);
            }
            if (TextUtils.isEmpty(charSequence)) {
                if (c37142a.asK != null) {
                    c37142a.asK.setSingleLine(false);
                    c37142a.asK.setMaxLines(2);
                }
            } else if (c37142a.asK != null) {
                c37142a.asK.setSingleLine(true);
                c37142a.asK.setMaxLines(1);
            }
            C37143ax.m62176a(c37142a.asL, charSequence);
        }
        if (c37142a.asM != null) {
            Drawable drawable2;
            ImageView imageView = c37142a.asM;
            if (this.asH == -1) {
                drawable2 = null;
            } else {
                drawable2 = m62171V(cursor.getString(this.asH));
                if (drawable2 == null) {
                    ComponentName searchActivity = this.aro.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.art.containsKey(flattenToShortString)) {
                        ConstantState constantState = (ConstantState) this.art.get(flattenToShortString);
                        if (constantState == null) {
                            drawable2 = null;
                        } else {
                            drawable2 = constantState.newDrawable(this.asA.getResources());
                        }
                    } else {
                        Drawable activityIcon = getActivityIcon(searchActivity);
                        this.art.put(flattenToShortString, activityIcon == null ? null : activityIcon.getConstantState());
                        drawable2 = activityIcon;
                    }
                    if (drawable2 == null) {
                        drawable2 = this.mContext.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            C37143ax.m62175a(imageView, drawable2, 4);
        }
        if (c37142a.asN != null) {
            ImageView imageView2 = c37142a.asN;
            if (this.asI != -1) {
                drawable = m62171V(cursor.getString(this.asI));
            }
            C37143ax.m62175a(imageView2, drawable, 8);
        }
        if (this.asC == 2 || (this.asC == 1 && (i & 1) != 0)) {
            c37142a.asO.setVisibility(0);
            c37142a.asO.setTag(c37142a.asK.getText());
            c37142a.asO.setOnClickListener(this);
            return;
        }
        c37142a.asO.setVisibility(8);
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.arD.setQuery((CharSequence) tag);
        }
    }

    /* renamed from: a */
    private static void m62176a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: a */
    private static void m62175a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = C37143ax.m62174a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.aro.shouldRewriteQueryFromData()) {
            a = C37143ax.m62174a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.aro.shouldRewriteQueryFromText()) {
            return null;
        }
        a = C37143ax.m62174a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            View newView = newView(this.mContext, this.f16838PI, viewGroup);
            if (newView != null) {
                ((C37142a) newView.getTag()).asK.setText(e.toString());
            }
            return newView;
        }
    }

    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            View newDropDownView = newDropDownView(this.mContext, this.f16838PI, viewGroup);
            if (newDropDownView != null) {
                ((C37142a) newDropDownView.getTag()).asK.setText(e.toString());
            }
            return newDropDownView;
        }
    }

    /* renamed from: V */
    private Drawable m62171V(String str) {
        if (str == null || str.isEmpty() || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            return null;
        }
        Drawable W;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.asA.getPackageName() + "/" + parseInt;
            W = m62172W(str2);
            if (W != null) {
                return W;
            }
            W = C0380b.m649g(this.asA, parseInt);
            m62177a(str2, W);
            return W;
        } catch (NumberFormatException e) {
            W = m62172W(str);
            if (W != null) {
                return W;
            }
            W = m62179d(Uri.parse(str));
            m62177a(str, W);
            return W;
        } catch (NotFoundException e2) {
            return null;
        }
    }

    /* renamed from: d */
    private Drawable m62179d(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m62180e(uri);
            }
            openInputStream = this.asA.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open ".concat(String.valueOf(uri)));
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (IOException e) {
                new StringBuilder("Error closing icon stream for ").append(uri);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: ".concat(String.valueOf(uri)));
        } catch (FileNotFoundException e3) {
            new StringBuilder("Icon not found: ").append(uri).append(", ").append(e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (IOException e4) {
                new StringBuilder("Error closing icon stream for ").append(uri);
            }
        }
    }

    /* renamed from: W */
    private Drawable m62172W(String str) {
        ConstantState constantState = (ConstantState) this.art.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: a */
    private void m62177a(String str, Drawable drawable) {
        if (drawable != null) {
            this.art.put(str, drawable.getConstantState());
        }
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            new StringBuilder("Invalid icon resource ").append(iconResource).append(" for ").append(componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m62174a(Cursor cursor, String str) {
        return C37143ax.m62173a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private static String m62173a(Cursor cursor, int i) {
        String str = null;
        if (i == -1) {
            return str;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: e */
    private Drawable m62180e(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: ".concat(String.valueOf(uri)));
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: ".concat(String.valueOf(uri)));
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(uri)));
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: ".concat(String.valueOf(uri)));
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: ".concat(String.valueOf(uri)));
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: ".concat(String.valueOf(uri)));
        }
    }
}
