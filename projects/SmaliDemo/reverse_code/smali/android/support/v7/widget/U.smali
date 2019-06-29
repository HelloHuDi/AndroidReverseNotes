.class public Landroid/support/v7/widget/U;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/z;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/widget/U$c;,
        Landroid/support/v7/widget/U$d;,
        Landroid/support/v7/widget/U$e;,
        Landroid/support/v7/widget/U$a;,
        Landroid/support/v7/widget/U$b;
    }
.end annotation


# static fields
.field private static a:Ljava/lang/reflect/Method;

.field private static b:Ljava/lang/reflect/Method;

.field private static c:Ljava/lang/reflect/Method;


# instance fields
.field final A:Landroid/support/v7/widget/U$e;

.field private final B:Landroid/support/v7/widget/U$d;

.field private final C:Landroid/support/v7/widget/U$c;

.field private final D:Landroid/support/v7/widget/U$a;

.field private E:Ljava/lang/Runnable;

.field final F:Landroid/os/Handler;

.field private final G:Landroid/graphics/Rect;

.field private H:Landroid/graphics/Rect;

.field private I:Z

.field J:Landroid/widget/PopupWindow;

.field private d:Landroid/content/Context;

.field private e:Landroid/widget/ListAdapter;

.field f:Landroid/support/v7/widget/N;

.field private g:I

.field private h:I

.field private i:I

.field private j:I

.field private k:I

.field private l:Z

.field private m:Z

.field private n:Z

.field private o:Z

.field private p:I

.field private q:Z

.field private r:Z

.field s:I

.field private t:Landroid/view/View;

.field private u:I

.field private v:Landroid/database/DataSetObserver;

.field private w:Landroid/view/View;

.field private x:Landroid/graphics/drawable/Drawable;

.field private y:Landroid/widget/AdapterView$OnItemClickListener;

.field private z:Landroid/widget/AdapterView$OnItemSelectedListener;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .line 84
    const-string v0, "ListPopupWindow"

    const/4 v1, 0x0

    const/4 v2, 0x1

    :try_start_0
    const-class v3, Landroid/widget/PopupWindow;

    const-string v4, "setClipToScreenEnabled"

    new-array v5, v2, [Ljava/lang/Class;

    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v6, v5, v1

    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    sput-object v3, Landroid/support/v7/widget/U;->a:Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    .line 88
    goto :goto_0

    .line 86
    :catch_0
    move-exception v3

    .line 87
    .local v3, "e":Ljava/lang/NoSuchMethodException;
    const-string v4, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well."

    invoke-static {v0, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 90
    .end local v3    # "e":Ljava/lang/NoSuchMethodException;
    :goto_0
    :try_start_1
    const-class v3, Landroid/widget/PopupWindow;

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Class;

    const-class v5, Landroid/view/View;

    aput-object v5, v4, v1

    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v4, v2

    const/4 v5, 0x2

    sget-object v6, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5
    :try_end_1
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_1

    const-string v5, "getMaxAvailableHeight"

    :try_start_2
    invoke-virtual {v3, v5, v4}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    sput-object v3, Landroid/support/v7/widget/U;->b:Ljava/lang/reflect/Method;
    :try_end_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2 .. :try_end_2} :catch_1

    .line 95
    goto :goto_1

    .line 92
    :catch_1
    move-exception v3

    .line 93
    .restart local v3    # "e":Ljava/lang/NoSuchMethodException;
    const-string v4, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well."

    invoke-static {v0, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    .end local v3    # "e":Ljava/lang/NoSuchMethodException;
    :goto_1
    :try_start_3
    const-class v3, Landroid/widget/PopupWindow;

    const-string v4, "setEpicenterBounds"

    new-array v2, v2, [Ljava/lang/Class;

    const-class v5, Landroid/graphics/Rect;

    aput-object v5, v2, v1

    invoke-virtual {v3, v4, v2}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    sput-object v1, Landroid/support/v7/widget/U;->c:Ljava/lang/reflect/Method;
    :try_end_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_3 .. :try_end_3} :catch_2

    .line 101
    goto :goto_2

    .line 99
    :catch_2
    move-exception v1

    .line 100
    .local v1, "e":Ljava/lang/NoSuchMethodException;
    const-string v2, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well."

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 102
    .end local v1    # "e":Ljava/lang/NoSuchMethodException;
    :goto_2
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 242
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/support/v7/widget/U;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    .line 243
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I
    .param p4, "defStyleRes"    # I

    .line 255
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    const/4 v0, -0x2

    iput v0, p0, Landroid/support/v7/widget/U;->g:I

    .line 109
    iput v0, p0, Landroid/support/v7/widget/U;->h:I

    .line 112
    const/16 v0, 0x3ea

    iput v0, p0, Landroid/support/v7/widget/U;->k:I

    .line 114
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/U;->m:Z

    .line 118
    const/4 v1, 0x0

    iput v1, p0, Landroid/support/v7/widget/U;->p:I

    .line 120
    iput-boolean v1, p0, Landroid/support/v7/widget/U;->q:Z

    .line 121
    iput-boolean v1, p0, Landroid/support/v7/widget/U;->r:Z

    .line 122
    const v2, 0x7fffffff

    iput v2, p0, Landroid/support/v7/widget/U;->s:I

    .line 125
    iput v1, p0, Landroid/support/v7/widget/U;->u:I

    .line 136
    new-instance v2, Landroid/support/v7/widget/U$e;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/U$e;-><init>(Landroid/support/v7/widget/U;)V

    iput-object v2, p0, Landroid/support/v7/widget/U;->A:Landroid/support/v7/widget/U$e;

    .line 137
    new-instance v2, Landroid/support/v7/widget/U$d;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/U$d;-><init>(Landroid/support/v7/widget/U;)V

    iput-object v2, p0, Landroid/support/v7/widget/U;->B:Landroid/support/v7/widget/U$d;

    .line 138
    new-instance v2, Landroid/support/v7/widget/U$c;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/U$c;-><init>(Landroid/support/v7/widget/U;)V

    iput-object v2, p0, Landroid/support/v7/widget/U;->C:Landroid/support/v7/widget/U$c;

    .line 139
    new-instance v2, Landroid/support/v7/widget/U$a;

    invoke-direct {v2, p0}, Landroid/support/v7/widget/U$a;-><init>(Landroid/support/v7/widget/U;)V

    iput-object v2, p0, Landroid/support/v7/widget/U;->D:Landroid/support/v7/widget/U$a;

    .line 144
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2}, Landroid/graphics/Rect;-><init>()V

    iput-object v2, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    .line 256
    iput-object p1, p0, Landroid/support/v7/widget/U;->d:Landroid/content/Context;

    .line 257
    new-instance v2, Landroid/os/Handler;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v2, p0, Landroid/support/v7/widget/U;->F:Landroid/os/Handler;

    .line 259
    sget-object v2, La/b/d/a/j;->ListPopupWindow:[I

    invoke-virtual {p1, p2, v2, p3, p4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 261
    .local v2, "a":Landroid/content/res/TypedArray;
    sget v3, La/b/d/a/j;->ListPopupWindow_android_dropDownHorizontalOffset:I

    invoke-virtual {v2, v3, v1}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v3

    iput v3, p0, Landroid/support/v7/widget/U;->i:I

    .line 263
    sget v3, La/b/d/a/j;->ListPopupWindow_android_dropDownVerticalOffset:I

    invoke-virtual {v2, v3, v1}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v1

    iput v1, p0, Landroid/support/v7/widget/U;->j:I

    .line 265
    iget v1, p0, Landroid/support/v7/widget/U;->j:I

    if-eqz v1, :cond_0

    .line 266
    iput-boolean v0, p0, Landroid/support/v7/widget/U;->l:Z

    .line 268
    :cond_0
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 270
    new-instance v1, Landroid/support/v7/widget/v;

    invoke-direct {v1, p1, p2, p3, p4}, Landroid/support/v7/widget/v;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V

    iput-object v1, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    .line 271
    iget-object v1, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v1, v0}, Landroid/widget/PopupWindow;->setInputMethodMode(I)V

    .line 272
    return-void
.end method

.method private a(Landroid/view/View;IZ)I
    .locals 5
    .param p1, "anchor"    # Landroid/view/View;
    .param p2, "yOffset"    # I
    .param p3, "ignoreBottomDecorations"    # Z

    .line 1421
    sget-object v0, Landroid/support/v7/widget/U;->b:Ljava/lang/reflect/Method;

    if-eqz v0, :cond_0

    .line 1423
    :try_start_0
    iget-object v1, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    .line 1424
    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    .line 1423
    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return v0

    .line 1425
    :catch_0
    move-exception v0

    .line 1426
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "ListPopupWindow"

    const-string v2, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1430
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1, p2}, Landroid/widget/PopupWindow;->getMaxAvailableHeight(Landroid/view/View;I)I

    move-result v0

    return v0
.end method

.method private c(Z)V
    .locals 5
    .param p1, "clip"    # Z

    .line 1411
    sget-object v0, Landroid/support/v7/widget/U;->a:Ljava/lang/reflect/Method;

    if-eqz v0, :cond_0

    .line 1413
    :try_start_0
    iget-object v1, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1416
    goto :goto_0

    .line 1414
    :catch_0
    move-exception v0

    .line 1415
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "ListPopupWindow"

    const-string v2, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well."

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1418
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    :goto_0
    return-void
.end method

.method private l()I
    .locals 15

    .line 1136
    const/4 v0, 0x0

    .line 1138
    .local v0, "otherHeights":I
    iget-object v1, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    const/4 v2, -0x1

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-nez v1, :cond_6

    .line 1139
    iget-object v1, p0, Landroid/support/v7/widget/U;->d:Landroid/content/Context;

    .line 1147
    .local v1, "context":Landroid/content/Context;
    new-instance v5, Landroid/support/v7/widget/S;

    invoke-direct {v5, p0}, Landroid/support/v7/widget/S;-><init>(Landroid/support/v7/widget/U;)V

    iput-object v5, p0, Landroid/support/v7/widget/U;->E:Ljava/lang/Runnable;

    .line 1158
    iget-boolean v5, p0, Landroid/support/v7/widget/U;->I:Z

    xor-int/2addr v5, v4

    invoke-virtual {p0, v1, v5}, Landroid/support/v7/widget/U;->a(Landroid/content/Context;Z)Landroid/support/v7/widget/N;

    move-result-object v5

    iput-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 1159
    iget-object v5, p0, Landroid/support/v7/widget/U;->x:Landroid/graphics/drawable/Drawable;

    if-eqz v5, :cond_0

    .line 1160
    iget-object v6, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v6, v5}, Landroid/support/v7/widget/N;->setSelector(Landroid/graphics/drawable/Drawable;)V

    .line 1162
    :cond_0
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    iget-object v6, p0, Landroid/support/v7/widget/U;->e:Landroid/widget/ListAdapter;

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1163
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    iget-object v6, p0, Landroid/support/v7/widget/U;->y:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 1164
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v5, v4}, Landroid/widget/ListView;->setFocusable(Z)V

    .line 1165
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v5, v4}, Landroid/widget/ListView;->setFocusableInTouchMode(Z)V

    .line 1166
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    new-instance v6, Landroid/support/v7/widget/T;

    invoke-direct {v6, p0}, Landroid/support/v7/widget/T;-><init>(Landroid/support/v7/widget/U;)V

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 1184
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    iget-object v6, p0, Landroid/support/v7/widget/U;->C:Landroid/support/v7/widget/U$c;

    invoke-virtual {v5, v6}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 1186
    iget-object v5, p0, Landroid/support/v7/widget/U;->z:Landroid/widget/AdapterView$OnItemSelectedListener;

    if-eqz v5, :cond_1

    .line 1187
    iget-object v6, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v6, v5}, Landroid/widget/ListView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 1190
    :cond_1
    iget-object v5, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 1192
    .local v5, "dropDownView":Landroid/view/ViewGroup;
    iget-object v6, p0, Landroid/support/v7/widget/U;->t:Landroid/view/View;

    .line 1193
    .local v6, "hintView":Landroid/view/View;
    if-eqz v6, :cond_5

    .line 1196
    new-instance v7, Landroid/widget/LinearLayout;

    invoke-direct {v7, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 1197
    .local v7, "hintContainer":Landroid/widget/LinearLayout;
    invoke-virtual {v7, v4}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 1199
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;

    const/high16 v9, 0x3f800000    # 1.0f

    invoke-direct {v8, v2, v3, v9}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    .line 1203
    .local v8, "hintParams":Landroid/widget/LinearLayout$LayoutParams;
    iget v9, p0, Landroid/support/v7/widget/U;->u:I

    if-eqz v9, :cond_3

    if-eq v9, v4, :cond_2

    .line 1215
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Invalid hint position "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v10, p0, Landroid/support/v7/widget/U;->u:I

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v10, "ListPopupWindow"

    invoke-static {v10, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 1205
    :cond_2
    invoke-virtual {v7, v5, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 1206
    invoke-virtual {v7, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 1207
    goto :goto_0

    .line 1210
    :cond_3
    invoke-virtual {v7, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 1211
    invoke-virtual {v7, v5, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 1212
    nop

    .line 1223
    :goto_0
    iget v9, p0, Landroid/support/v7/widget/U;->h:I

    if-ltz v9, :cond_4

    .line 1224
    const/high16 v9, -0x80000000

    .line 1225
    .local v9, "widthMode":I
    iget v10, p0, Landroid/support/v7/widget/U;->h:I

    .local v10, "widthSize":I
    goto :goto_1

    .line 1227
    .end local v9    # "widthMode":I
    .end local v10    # "widthSize":I
    :cond_4
    const/4 v9, 0x0

    .line 1228
    .restart local v9    # "widthMode":I
    const/4 v10, 0x0

    .line 1230
    .restart local v10    # "widthSize":I
    :goto_1
    invoke-static {v10, v9}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v11

    .line 1231
    .local v11, "widthSpec":I
    const/4 v12, 0x0

    .line 1232
    .local v12, "heightSpec":I
    invoke-virtual {v6, v11, v3}, Landroid/view/View;->measure(II)V

    .line 1234
    invoke-virtual {v6}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v13

    move-object v8, v13

    check-cast v8, Landroid/widget/LinearLayout$LayoutParams;

    .line 1235
    invoke-virtual {v6}, Landroid/view/View;->getMeasuredHeight()I

    move-result v13

    iget v14, v8, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    add-int/2addr v13, v14

    iget v14, v8, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    add-int/2addr v13, v14

    .line 1238
    .end local v0    # "otherHeights":I
    .local v13, "otherHeights":I
    move-object v5, v7

    move v0, v13

    .line 1241
    .end local v7    # "hintContainer":Landroid/widget/LinearLayout;
    .end local v8    # "hintParams":Landroid/widget/LinearLayout$LayoutParams;
    .end local v9    # "widthMode":I
    .end local v10    # "widthSize":I
    .end local v11    # "widthSpec":I
    .end local v12    # "heightSpec":I
    .end local v13    # "otherHeights":I
    .restart local v0    # "otherHeights":I
    :cond_5
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v7, v5}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 1242
    .end local v1    # "context":Landroid/content/Context;
    .end local v6    # "hintView":Landroid/view/View;
    goto :goto_2

    .line 1243
    .end local v5    # "dropDownView":Landroid/view/ViewGroup;
    :cond_6
    iget-object v1, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;

    move-result-object v1

    move-object v5, v1

    check-cast v5, Landroid/view/ViewGroup;

    .line 1244
    .restart local v5    # "dropDownView":Landroid/view/ViewGroup;
    iget-object v1, p0, Landroid/support/v7/widget/U;->t:Landroid/view/View;

    .line 1245
    .local v1, "view":Landroid/view/View;
    if-eqz v1, :cond_7

    .line 1246
    nop

    .line 1247
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/widget/LinearLayout$LayoutParams;

    .line 1248
    .local v6, "hintParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v7

    iget v8, v6, Landroid/widget/LinearLayout$LayoutParams;->topMargin:I

    add-int/2addr v7, v8

    iget v8, v6, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin:I

    add-int v0, v7, v8

    .line 1256
    .end local v1    # "view":Landroid/view/View;
    .end local v6    # "hintParams":Landroid/widget/LinearLayout$LayoutParams;
    :cond_7
    :goto_2
    iget-object v1, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v1}, Landroid/widget/PopupWindow;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 1257
    .local v1, "background":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_8

    .line 1258
    iget-object v6, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    invoke-virtual {v1, v6}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 1259
    iget-object v6, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    iget v7, v6, Landroid/graphics/Rect;->top:I

    iget v6, v6, Landroid/graphics/Rect;->bottom:I

    add-int/2addr v6, v7

    .line 1263
    .local v6, "padding":I
    iget-boolean v8, p0, Landroid/support/v7/widget/U;->l:Z

    if-nez v8, :cond_9

    .line 1264
    neg-int v7, v7

    iput v7, p0, Landroid/support/v7/widget/U;->j:I

    goto :goto_3

    .line 1267
    .end local v6    # "padding":I
    :cond_8
    iget-object v6, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    invoke-virtual {v6}, Landroid/graphics/Rect;->setEmpty()V

    .line 1268
    const/4 v6, 0x0

    .line 1272
    .restart local v6    # "padding":I
    :cond_9
    :goto_3
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    .line 1273
    invoke-virtual {v7}, Landroid/widget/PopupWindow;->getInputMethodMode()I

    move-result v7

    const/4 v8, 0x2

    if-ne v7, v8, :cond_a

    const/4 v3, 0x1

    .line 1274
    .local v3, "ignoreBottomDecorations":Z
    :cond_a
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->e()Landroid/view/View;

    move-result-object v4

    iget v7, p0, Landroid/support/v7/widget/U;->j:I

    invoke-direct {p0, v4, v7, v3}, Landroid/support/v7/widget/U;->a(Landroid/view/View;IZ)I

    move-result v4

    .line 1276
    .local v4, "maxHeight":I
    iget-boolean v7, p0, Landroid/support/v7/widget/U;->q:Z

    if-nez v7, :cond_f

    iget v7, p0, Landroid/support/v7/widget/U;->g:I

    if-ne v7, v2, :cond_b

    goto :goto_5

    .line 1281
    :cond_b
    iget v7, p0, Landroid/support/v7/widget/U;->h:I

    const/4 v8, -0x2

    if-eq v7, v8, :cond_d

    const/high16 v8, 0x40000000    # 2.0f

    if-eq v7, v2, :cond_c

    .line 1295
    invoke-static {v7, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .local v2, "childWidthSpec":I
    goto :goto_4

    .line 1289
    .end local v2    # "childWidthSpec":I
    :cond_c
    iget-object v2, p0, Landroid/support/v7/widget/U;->d:Landroid/content/Context;

    .line 1290
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v7, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    iget v9, v7, Landroid/graphics/Rect;->left:I

    iget v7, v7, Landroid/graphics/Rect;->right:I

    add-int/2addr v9, v7

    sub-int/2addr v2, v9

    .line 1289
    invoke-static {v2, v8}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 1293
    .restart local v2    # "childWidthSpec":I
    goto :goto_4

    .line 1283
    .end local v2    # "childWidthSpec":I
    :cond_d
    iget-object v2, p0, Landroid/support/v7/widget/U;->d:Landroid/content/Context;

    .line 1284
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    iget-object v7, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    iget v8, v7, Landroid/graphics/Rect;->left:I

    iget v7, v7, Landroid/graphics/Rect;->right:I

    add-int/2addr v8, v7

    sub-int/2addr v2, v8

    const/high16 v7, -0x80000000

    .line 1283
    invoke-static {v2, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v2

    .line 1287
    .restart local v2    # "childWidthSpec":I
    nop

    .line 1301
    :goto_4
    iget-object v7, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    const/4 v9, 0x0

    const/4 v10, -0x1

    sub-int v11, v4, v0

    const/4 v12, -0x1

    move v8, v2

    invoke-virtual/range {v7 .. v12}, Landroid/support/v7/widget/N;->a(IIIII)I

    move-result v7

    .line 1303
    .local v7, "listContent":I
    if-lez v7, :cond_e

    .line 1304
    iget-object v8, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v8}, Landroid/widget/ListView;->getPaddingTop()I

    move-result v8

    iget-object v9, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 1305
    invoke-virtual {v9}, Landroid/widget/ListView;->getPaddingBottom()I

    move-result v9

    add-int/2addr v8, v9

    .line 1306
    .local v8, "listPadding":I
    add-int v9, v6, v8

    add-int/2addr v0, v9

    .line 1309
    .end local v8    # "listPadding":I
    :cond_e
    add-int v8, v7, v0

    return v8

    .line 1277
    .end local v2    # "childWidthSpec":I
    .end local v7    # "listContent":I
    :cond_f
    :goto_5
    add-int v2, v4, v6

    return v2
.end method

.method private m()V
    .locals 3

    .line 769
    iget-object v0, p0, Landroid/support/v7/widget/U;->t:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 770
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 771
    .local v0, "parent":Landroid/view/ViewParent;
    instance-of v1, v0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_0

    .line 772
    move-object v1, v0

    check-cast v1, Landroid/view/ViewGroup;

    .line 773
    .local v1, "group":Landroid/view/ViewGroup;
    iget-object v2, p0, Landroid/support/v7/widget/U;->t:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 776
    .end local v0    # "parent":Landroid/view/ViewParent;
    .end local v1    # "group":Landroid/view/ViewGroup;
    :cond_0
    return-void
.end method


# virtual methods
.method a(Landroid/content/Context;Z)Landroid/support/v7/widget/N;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "hijackFocus"    # Z

    .line 930
    new-instance v0, Landroid/support/v7/widget/N;

    invoke-direct {v0, p1, p2}, Landroid/support/v7/widget/N;-><init>(Landroid/content/Context;Z)V

    return-object v0
.end method

.method public a()V
    .locals 2

    .line 826
    iget-object v0, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 827
    .local v0, "list":Landroid/support/v7/widget/N;
    if-eqz v0, :cond_0

    .line 829
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/N;->setListSelectionHidden(Z)V

    .line 831
    invoke-virtual {v0}, Landroid/widget/ListView;->requestLayout()V

    .line 833
    :cond_0
    return-void
.end method

.method public a(I)V
    .locals 1
    .param p1, "animationStyle"    # I

    .line 435
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 436
    return-void
.end method

.method public a(Landroid/graphics/Rect;)V
    .locals 0
    .param p1, "bounds"    # Landroid/graphics/Rect;

    .line 512
    iput-object p1, p0, Landroid/support/v7/widget/U;->H:Landroid/graphics/Rect;

    .line 513
    return-void
.end method

.method public a(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .line 426
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 427
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 0
    .param p1, "anchor"    # Landroid/view/View;

    .line 464
    iput-object p1, p0, Landroid/support/v7/widget/U;->w:Landroid/view/View;

    .line 465
    return-void
.end method

.method public a(Landroid/widget/AdapterView$OnItemClickListener;)V
    .locals 0
    .param p1, "clickListener"    # Landroid/widget/AdapterView$OnItemClickListener;

    .line 603
    iput-object p1, p0, Landroid/support/v7/widget/U;->y:Landroid/widget/AdapterView$OnItemClickListener;

    .line 604
    return-void
.end method

.method public a(Landroid/widget/ListAdapter;)V
    .locals 2
    .param p1, "adapter"    # Landroid/widget/ListAdapter;

    .line 281
    iget-object v0, p0, Landroid/support/v7/widget/U;->v:Landroid/database/DataSetObserver;

    if-nez v0, :cond_0

    .line 282
    new-instance v0, Landroid/support/v7/widget/U$b;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/U$b;-><init>(Landroid/support/v7/widget/U;)V

    iput-object v0, p0, Landroid/support/v7/widget/U;->v:Landroid/database/DataSetObserver;

    goto :goto_0

    .line 283
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/U;->e:Landroid/widget/ListAdapter;

    if-eqz v1, :cond_1

    .line 284
    invoke-interface {v1, v0}, Landroid/widget/ListAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 286
    :cond_1
    :goto_0
    iput-object p1, p0, Landroid/support/v7/widget/U;->e:Landroid/widget/ListAdapter;

    .line 287
    if-eqz p1, :cond_2

    .line 288
    iget-object v0, p0, Landroid/support/v7/widget/U;->v:Landroid/database/DataSetObserver;

    invoke-interface {p1, v0}, Landroid/widget/ListAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 291
    :cond_2
    iget-object v0, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    if-eqz v0, :cond_3

    .line 292
    iget-object v1, p0, Landroid/support/v7/widget/U;->e:Landroid/widget/ListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 294
    :cond_3
    return-void
.end method

.method public a(Landroid/widget/PopupWindow$OnDismissListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/widget/PopupWindow$OnDismissListener;

    .line 765
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1}, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 766
    return-void
.end method

.method public a(Z)V
    .locals 1
    .param p1, "modal"    # Z

    .line 329
    iput-boolean p1, p0, Landroid/support/v7/widget/U;->I:Z

    .line 330
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 331
    return-void
.end method

.method public b(I)V
    .locals 3
    .param p1, "width"    # I

    .line 549
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 550
    .local v0, "popupBackground":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 551
    iget-object v1, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    .line 552
    iget-object v1, p0, Landroid/support/v7/widget/U;->G:Landroid/graphics/Rect;

    iget v2, v1, Landroid/graphics/Rect;->left:I

    iget v1, v1, Landroid/graphics/Rect;->right:I

    add-int/2addr v2, v1

    add-int/2addr v2, p1

    iput v2, p0, Landroid/support/v7/widget/U;->h:I

    goto :goto_0

    .line 554
    :cond_0
    invoke-virtual {p0, p1}, Landroid/support/v7/widget/U;->i(I)V

    .line 556
    :goto_0
    return-void
.end method

.method public b(Z)V
    .locals 1
    .param p1, "overlapAnchor"    # Z

    .line 1318
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/U;->o:Z

    .line 1319
    iput-boolean p1, p0, Landroid/support/v7/widget/U;->n:Z

    .line 1320
    return-void
.end method

.method public b()Z
    .locals 1

    .line 840
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    return v0
.end method

.method public c()V
    .locals 14

    .line 647
    invoke-direct {p0}, Landroid/support/v7/widget/U;->l()I

    move-result v0

    .line 649
    .local v0, "height":I
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->j()Z

    move-result v1

    .line 650
    .local v1, "noInputMethod":Z
    iget-object v2, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget v3, p0, Landroid/support/v7/widget/U;->k:I

    invoke-static {v2, v3}, Landroid/support/v4/widget/k;->a(Landroid/widget/PopupWindow;I)V

    .line 652
    iget-object v2, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v2

    const/4 v3, 0x1

    const/4 v4, -0x2

    const/4 v5, 0x0

    const/4 v6, -0x1

    if-eqz v2, :cond_c

    .line 653
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->e()Landroid/view/View;

    move-result-object v2

    invoke-static {v2}, La/b/c/g/u;->j(Landroid/view/View;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 655
    return-void

    .line 658
    :cond_0
    iget v2, p0, Landroid/support/v7/widget/U;->h:I

    if-ne v2, v6, :cond_1

    .line 661
    const/4 v2, -0x1

    .local v2, "widthSpec":I
    goto :goto_0

    .line 662
    .end local v2    # "widthSpec":I
    :cond_1
    if-ne v2, v4, :cond_2

    .line 663
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->e()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    .restart local v2    # "widthSpec":I
    goto :goto_0

    .line 665
    .end local v2    # "widthSpec":I
    :cond_2
    iget v2, p0, Landroid/support/v7/widget/U;->h:I

    .line 669
    .restart local v2    # "widthSpec":I
    :goto_0
    iget v7, p0, Landroid/support/v7/widget/U;->g:I

    if-ne v7, v6, :cond_7

    .line 672
    if-eqz v1, :cond_3

    move v4, v0

    goto :goto_1

    :cond_3
    const/4 v4, -0x1

    .line 673
    .local v4, "heightSpec":I
    :goto_1
    if-eqz v1, :cond_5

    .line 674
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget v8, p0, Landroid/support/v7/widget/U;->h:I

    if-ne v8, v6, :cond_4

    const/4 v8, -0x1

    goto :goto_2

    :cond_4
    const/4 v8, 0x0

    :goto_2
    invoke-virtual {v7, v8}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 676
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v7, v5}, Landroid/widget/PopupWindow;->setHeight(I)V

    goto :goto_4

    .line 678
    :cond_5
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget v8, p0, Landroid/support/v7/widget/U;->h:I

    if-ne v8, v6, :cond_6

    const/4 v8, -0x1

    goto :goto_3

    :cond_6
    const/4 v8, 0x0

    :goto_3
    invoke-virtual {v7, v8}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 680
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v7, v6}, Landroid/widget/PopupWindow;->setHeight(I)V

    goto :goto_4

    .line 682
    .end local v4    # "heightSpec":I
    :cond_7
    if-ne v7, v4, :cond_8

    .line 683
    move v4, v0

    .restart local v4    # "heightSpec":I
    goto :goto_4

    .line 685
    .end local v4    # "heightSpec":I
    :cond_8
    iget v4, p0, Landroid/support/v7/widget/U;->g:I

    .line 688
    .restart local v4    # "heightSpec":I
    :goto_4
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget-boolean v8, p0, Landroid/support/v7/widget/U;->r:Z

    if-nez v8, :cond_9

    iget-boolean v8, p0, Landroid/support/v7/widget/U;->q:Z

    if-nez v8, :cond_9

    goto :goto_5

    :cond_9
    const/4 v3, 0x0

    :goto_5
    invoke-virtual {v7, v3}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 690
    iget-object v8, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {p0}, Landroid/support/v7/widget/U;->e()Landroid/view/View;

    move-result-object v9

    iget v10, p0, Landroid/support/v7/widget/U;->i:I

    iget v11, p0, Landroid/support/v7/widget/U;->j:I

    if-gez v2, :cond_a

    const/4 v12, -0x1

    goto :goto_6

    :cond_a
    move v12, v2

    :goto_6
    if-gez v4, :cond_b

    const/4 v13, -0x1

    goto :goto_7

    :cond_b
    move v13, v4

    :goto_7
    invoke-virtual/range {v8 .. v13}, Landroid/widget/PopupWindow;->update(Landroid/view/View;IIII)V

    .line 693
    .end local v2    # "widthSpec":I
    .end local v4    # "heightSpec":I
    goto/16 :goto_c

    .line 695
    :cond_c
    iget v2, p0, Landroid/support/v7/widget/U;->h:I

    if-ne v2, v6, :cond_d

    .line 696
    const/4 v2, -0x1

    .restart local v2    # "widthSpec":I
    goto :goto_8

    .line 698
    .end local v2    # "widthSpec":I
    :cond_d
    if-ne v2, v4, :cond_e

    .line 699
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->e()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v2

    .restart local v2    # "widthSpec":I
    goto :goto_8

    .line 701
    .end local v2    # "widthSpec":I
    :cond_e
    iget v2, p0, Landroid/support/v7/widget/U;->h:I

    .line 706
    .restart local v2    # "widthSpec":I
    :goto_8
    iget v7, p0, Landroid/support/v7/widget/U;->g:I

    if-ne v7, v6, :cond_f

    .line 707
    const/4 v4, -0x1

    .restart local v4    # "heightSpec":I
    goto :goto_9

    .line 709
    .end local v4    # "heightSpec":I
    :cond_f
    if-ne v7, v4, :cond_10

    .line 710
    move v4, v0

    .restart local v4    # "heightSpec":I
    goto :goto_9

    .line 712
    .end local v4    # "heightSpec":I
    :cond_10
    iget v4, p0, Landroid/support/v7/widget/U;->g:I

    .line 716
    .restart local v4    # "heightSpec":I
    :goto_9
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v7, v2}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 717
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v7, v4}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 718
    invoke-direct {p0, v3}, Landroid/support/v7/widget/U;->c(Z)V

    .line 722
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget-boolean v8, p0, Landroid/support/v7/widget/U;->r:Z

    if-nez v8, :cond_11

    iget-boolean v8, p0, Landroid/support/v7/widget/U;->q:Z

    if-nez v8, :cond_11

    const/4 v8, 0x1

    goto :goto_a

    :cond_11
    const/4 v8, 0x0

    :goto_a
    invoke-virtual {v7, v8}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 723
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget-object v8, p0, Landroid/support/v7/widget/U;->B:Landroid/support/v7/widget/U$d;

    invoke-virtual {v7, v8}, Landroid/widget/PopupWindow;->setTouchInterceptor(Landroid/view/View$OnTouchListener;)V

    .line 724
    iget-boolean v7, p0, Landroid/support/v7/widget/U;->o:Z

    if-eqz v7, :cond_12

    .line 725
    iget-object v7, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    iget-boolean v8, p0, Landroid/support/v7/widget/U;->n:Z

    invoke-static {v7, v8}, Landroid/support/v4/widget/k;->a(Landroid/widget/PopupWindow;Z)V

    .line 727
    :cond_12
    sget-object v7, Landroid/support/v7/widget/U;->c:Ljava/lang/reflect/Method;

    if-eqz v7, :cond_13

    .line 729
    :try_start_0
    iget-object v8, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v9, p0, Landroid/support/v7/widget/U;->H:Landroid/graphics/Rect;

    aput-object v9, v3, v5

    invoke-virtual {v7, v8, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 732
    goto :goto_b

    .line 730
    :catch_0
    move-exception v3

    .line 731
    .local v3, "e":Ljava/lang/Exception;
    const-string v5, "ListPopupWindow"

    const-string v7, "Could not invoke setEpicenterBounds on PopupWindow"

    invoke-static {v5, v7, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 734
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_13
    :goto_b
    iget-object v3, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {p0}, Landroid/support/v7/widget/U;->e()Landroid/view/View;

    move-result-object v5

    iget v7, p0, Landroid/support/v7/widget/U;->i:I

    iget v8, p0, Landroid/support/v7/widget/U;->j:I

    iget v9, p0, Landroid/support/v7/widget/U;->p:I

    invoke-static {v3, v5, v7, v8, v9}, Landroid/support/v4/widget/k;->a(Landroid/widget/PopupWindow;Landroid/view/View;III)V

    .line 736
    iget-object v3, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v3, v6}, Landroid/widget/ListView;->setSelection(I)V

    .line 738
    iget-boolean v3, p0, Landroid/support/v7/widget/U;->I:Z

    if-eqz v3, :cond_14

    iget-object v3, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    invoke-virtual {v3}, Landroid/support/v7/widget/N;->isInTouchMode()Z

    move-result v3

    if-eqz v3, :cond_15

    .line 739
    :cond_14
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->a()V

    .line 741
    :cond_15
    iget-boolean v3, p0, Landroid/support/v7/widget/U;->I:Z

    if-nez v3, :cond_16

    .line 742
    iget-object v3, p0, Landroid/support/v7/widget/U;->F:Landroid/os/Handler;

    iget-object v5, p0, Landroid/support/v7/widget/U;->D:Landroid/support/v7/widget/U$a;

    invoke-virtual {v3, v5}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 745
    .end local v2    # "widthSpec":I
    .end local v4    # "heightSpec":I
    :cond_16
    :goto_c
    return-void
.end method

.method public c(I)V
    .locals 0
    .param p1, "gravity"    # I

    .line 522
    iput p1, p0, Landroid/support/v7/widget/U;->p:I

    .line 523
    return-void
.end method

.method public d()Landroid/widget/ListView;
    .locals 1

    .line 926
    iget-object v0, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    return-object v0
.end method

.method public d(I)V
    .locals 0
    .param p1, "offset"    # I

    .line 480
    iput p1, p0, Landroid/support/v7/widget/U;->i:I

    .line 481
    return-void
.end method

.method public dismiss()V
    .locals 2

    .line 752
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 753
    invoke-direct {p0}, Landroid/support/v7/widget/U;->m()V

    .line 754
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 755
    iput-object v1, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 756
    iget-object v0, p0, Landroid/support/v7/widget/U;->F:Landroid/os/Handler;

    iget-object v1, p0, Landroid/support/v7/widget/U;->A:Landroid/support/v7/widget/U$e;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 757
    return-void
.end method

.method public e()Landroid/view/View;
    .locals 1

    .line 454
    iget-object v0, p0, Landroid/support/v7/widget/U;->w:Landroid/view/View;

    return-object v0
.end method

.method public e(I)V
    .locals 1
    .param p1, "mode"    # I

    .line 791
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1}, Landroid/widget/PopupWindow;->setInputMethodMode(I)V

    .line 792
    return-void
.end method

.method public f()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 417
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public f(I)V
    .locals 0
    .param p1, "position"    # I

    .line 306
    iput p1, p0, Landroid/support/v7/widget/U;->u:I

    .line 307
    return-void
.end method

.method public g()I
    .locals 1

    .line 471
    iget v0, p0, Landroid/support/v7/widget/U;->i:I

    return v0
.end method

.method public g(I)V
    .locals 2
    .param p1, "position"    # I

    .line 810
    iget-object v0, p0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 811
    .local v0, "list":Landroid/support/v7/widget/N;
    invoke-virtual {p0}, Landroid/support/v7/widget/U;->b()Z

    move-result v1

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 812
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/N;->setListSelectionHidden(Z)V

    .line 813
    invoke-virtual {v0, p1}, Landroid/widget/ListView;->setSelection(I)V

    .line 815
    invoke-virtual {v0}, Landroid/widget/ListView;->getChoiceMode()I

    move-result v1

    if-eqz v1, :cond_0

    .line 816
    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 819
    :cond_0
    return-void
.end method

.method public h()I
    .locals 1

    .line 487
    iget-boolean v0, p0, Landroid/support/v7/widget/U;->l:Z

    if-nez v0, :cond_0

    .line 488
    const/4 v0, 0x0

    return v0

    .line 490
    :cond_0
    iget v0, p0, Landroid/support/v7/widget/U;->j:I

    return v0
.end method

.method public h(I)V
    .locals 1
    .param p1, "offset"    # I

    .line 499
    iput p1, p0, Landroid/support/v7/widget/U;->j:I

    .line 500
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/U;->l:Z

    .line 501
    return-void
.end method

.method public i()I
    .locals 1

    .line 529
    iget v0, p0, Landroid/support/v7/widget/U;->h:I

    return v0
.end method

.method public i(I)V
    .locals 0
    .param p1, "width"    # I

    .line 539
    iput p1, p0, Landroid/support/v7/widget/U;->h:I

    .line 540
    return-void
.end method

.method public j()Z
    .locals 2

    .line 848
    iget-object v0, p0, Landroid/support/v7/widget/U;->J:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->getInputMethodMode()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public k()Z
    .locals 1

    .line 339
    iget-boolean v0, p0, Landroid/support/v7/widget/U;->I:Z

    return v0
.end method
