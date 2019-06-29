.class Landroid/support/v7/app/x;
.super Landroid/support/v7/app/o;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/l$a;
.implements Landroid/view/LayoutInflater$Factory2;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/x$d;,
        Landroid/support/v7/app/x$c;,
        Landroid/support/v7/app/x$e;,
        Landroid/support/v7/app/x$f;,
        Landroid/support/v7/app/x$a;,
        Landroid/support/v7/app/x$g;,
        Landroid/support/v7/app/x$b;
    }
.end annotation


# static fields
.field private static final b:Z

.field private static final c:[I

.field private static d:Z


# instance fields
.field private A:Z

.field B:Z

.field C:Z

.field D:Z

.field E:Z

.field F:Z

.field private G:Z

.field private H:[Landroid/support/v7/app/x$f;

.field private I:Landroid/support/v7/app/x$f;

.field private J:Z

.field K:Z

.field private L:I

.field private M:Z

.field private N:Landroid/support/v7/app/x$d;

.field O:Z

.field P:I

.field private final Q:Ljava/lang/Runnable;

.field private R:Z

.field private S:Landroid/graphics/Rect;

.field private T:Landroid/graphics/Rect;

.field private U:Landroid/support/v7/app/AppCompatViewInflater;

.field final e:Landroid/content/Context;

.field final f:Landroid/view/Window;

.field final g:Landroid/view/Window$Callback;

.field final h:Landroid/view/Window$Callback;

.field final i:Landroid/support/v7/app/n;

.field j:Landroid/support/v7/app/a;

.field k:Landroid/view/MenuInflater;

.field private l:Ljava/lang/CharSequence;

.field private m:Landroid/support/v7/widget/K;

.field private n:Landroid/support/v7/app/x$a;

.field private o:Landroid/support/v7/app/x$g;

.field p:La/b/d/d/b;

.field q:Landroid/support/v7/widget/ActionBarContextView;

.field r:Landroid/widget/PopupWindow;

.field s:Ljava/lang/Runnable;

.field t:La/b/c/g/A;

.field private u:Z

.field private v:Z

.field private w:Landroid/view/ViewGroup;

.field private x:Landroid/widget/TextView;

.field private y:Landroid/view/View;

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 116
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/16 v3, 0x15

    if-ge v0, v3, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    sput-boolean v0, Landroid/support/v7/app/x;->b:Z

    .line 119
    new-array v0, v2, [I

    const v3, 0x1010054

    aput v3, v0, v1

    sput-object v0, Landroid/support/v7/app/x;->c:[I

    .line 128
    sget-boolean v0, Landroid/support/v7/app/x;->b:Z

    if-eqz v0, :cond_1

    sget-boolean v0, Landroid/support/v7/app/x;->d:Z

    if-nez v0, :cond_1

    .line 130
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v0

    .line 132
    .local v0, "defHandler":Ljava/lang/Thread$UncaughtExceptionHandler;
    new-instance v1, Landroid/support/v7/app/p;

    invoke-direct {v1, v0}, Landroid/support/v7/app/p;-><init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    invoke-static {v1}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 157
    sput-boolean v2, Landroid/support/v7/app/x;->d:Z

    .line 159
    .end local v0    # "defHandler":Ljava/lang/Thread$UncaughtExceptionHandler;
    :cond_1
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/view/Window;Landroid/support/v7/app/n;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "window"    # Landroid/view/Window;
    .param p3, "callback"    # Landroid/support/v7/app/n;

    .line 244
    invoke-direct {p0}, Landroid/support/v7/app/o;-><init>()V

    .line 180
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 182
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/app/x;->u:Z

    .line 215
    const/16 v1, -0x64

    iput v1, p0, Landroid/support/v7/app/x;->L:I

    .line 223
    new-instance v1, Landroid/support/v7/app/q;

    invoke-direct {v1, p0}, Landroid/support/v7/app/q;-><init>(Landroid/support/v7/app/x;)V

    iput-object v1, p0, Landroid/support/v7/app/x;->Q:Ljava/lang/Runnable;

    .line 245
    iput-object p1, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 246
    iput-object p2, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    .line 247
    iput-object p3, p0, Landroid/support/v7/app/x;->i:Landroid/support/v7/app/n;

    .line 249
    iget-object v1, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    .line 250
    iget-object v1, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    instance-of v2, v1, Landroid/support/v7/app/x$c;

    if-nez v2, :cond_1

    .line 254
    new-instance v2, Landroid/support/v7/app/x$c;

    invoke-direct {v2, p0, v1}, Landroid/support/v7/app/x$c;-><init>(Landroid/support/v7/app/x;Landroid/view/Window$Callback;)V

    iput-object v2, p0, Landroid/support/v7/app/x;->h:Landroid/view/Window$Callback;

    .line 256
    iget-object v1, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    iget-object v2, p0, Landroid/support/v7/app/x;->h:Landroid/view/Window$Callback;

    invoke-virtual {v1, v2}, Landroid/view/Window;->setCallback(Landroid/view/Window$Callback;)V

    .line 258
    sget-object v1, Landroid/support/v7/app/x;->c:[I

    invoke-static {p1, v0, v1}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[I)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 260
    .local v0, "a":Landroid/support/v7/widget/ta;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ta;->c(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 261
    .local v1, "winBg":Landroid/graphics/drawable/Drawable;
    if-eqz v1, :cond_0

    .line 262
    iget-object v2, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v2, v1}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 264
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    .line 265
    return-void

    .line 251
    .end local v0    # "a":Landroid/support/v7/widget/ta;
    .end local v1    # "winBg":Landroid/graphics/drawable/Drawable;
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "AppCompat has already installed itself into the Window"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private A()V
    .locals 2

    .line 1951
    iget-boolean v0, p0, Landroid/support/v7/app/x;->v:Z

    if-nez v0, :cond_0

    .line 1955
    return-void

    .line 1952
    :cond_0
    new-instance v0, Landroid/util/AndroidRuntimeException;

    const-string v1, "Window feature must be requested before adding content"

    invoke-direct {v0, v1}, Landroid/util/AndroidRuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private a(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)V
    .locals 19
    .param p1, "st"    # Landroid/support/v7/app/x$f;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1329
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-boolean v2, v1, Landroid/support/v7/app/x$f;->o:Z

    if-nez v2, :cond_11

    iget-boolean v2, v0, Landroid/support/v7/app/x;->K:Z

    if-eqz v2, :cond_0

    goto/16 :goto_5

    .line 1335
    :cond_0
    iget v2, v1, Landroid/support/v7/app/x$f;->a:I

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-nez v2, :cond_2

    .line 1336
    iget-object v2, v0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v2

    .line 1337
    .local v2, "config":Landroid/content/res/Configuration;
    iget v5, v2, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v5, v5, 0xf

    const/4 v6, 0x4

    if-ne v5, v6, :cond_1

    const/4 v5, 0x1

    goto :goto_0

    :cond_1
    const/4 v5, 0x0

    .line 1339
    .local v5, "isXLarge":Z
    :goto_0
    if-eqz v5, :cond_2

    .line 1340
    return-void

    .line 1344
    .end local v2    # "config":Landroid/content/res/Configuration;
    .end local v5    # "isXLarge":Z
    :cond_2
    invoke-virtual/range {p0 .. p0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v2

    .line 1345
    .local v2, "cb":Landroid/view/Window$Callback;
    if-eqz v2, :cond_3

    iget v5, v1, Landroid/support/v7/app/x$f;->a:I

    iget-object v6, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-interface {v2, v5, v6}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 1347
    invoke-virtual {v0, v1, v4}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1348
    return-void

    .line 1351
    :cond_3
    iget-object v5, v0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    const-string v6, "window"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/WindowManager;

    .line 1352
    .local v5, "wm":Landroid/view/WindowManager;
    if-nez v5, :cond_4

    .line 1353
    return-void

    .line 1357
    :cond_4
    invoke-direct/range {p0 .. p2}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    move-result v6

    if-nez v6, :cond_5

    .line 1358
    return-void

    .line 1361
    :cond_5
    const/4 v6, -0x2

    .line 1362
    .local v6, "width":I
    iget-object v7, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    if-eqz v7, :cond_8

    iget-boolean v7, v1, Landroid/support/v7/app/x$f;->q:Z

    if-eqz v7, :cond_6

    goto :goto_2

    .line 1398
    :cond_6
    iget-object v7, v1, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    if-eqz v7, :cond_7

    .line 1401
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    .line 1402
    .local v7, "lp":Landroid/view/ViewGroup$LayoutParams;
    if-eqz v7, :cond_f

    iget v8, v7, Landroid/view/ViewGroup$LayoutParams;->width:I

    const/4 v9, -0x1

    if-ne v8, v9, :cond_f

    .line 1403
    const/4 v6, -0x1

    goto/16 :goto_3

    .line 1398
    .end local v7    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_7
    :goto_1
    goto :goto_3

    .line 1363
    :cond_8
    :goto_2
    iget-object v7, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    if-nez v7, :cond_a

    .line 1365
    invoke-direct/range {p0 .. p1}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;)Z

    move-result v7

    if-eqz v7, :cond_9

    iget-object v7, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    if-nez v7, :cond_b

    .line 1366
    :cond_9
    return-void

    .line 1367
    :cond_a
    iget-boolean v8, v1, Landroid/support/v7/app/x$f;->q:Z

    if-eqz v8, :cond_b

    invoke-virtual {v7}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v7

    if-lez v7, :cond_b

    .line 1369
    iget-object v7, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    invoke-virtual {v7}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 1373
    :cond_b
    invoke-direct/range {p0 .. p1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;)Z

    move-result v7

    if-eqz v7, :cond_10

    invoke-virtual/range {p1 .. p1}, Landroid/support/v7/app/x$f;->a()Z

    move-result v7

    if-nez v7, :cond_c

    goto :goto_4

    .line 1377
    :cond_c
    iget-object v7, v1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    .line 1378
    .restart local v7    # "lp":Landroid/view/ViewGroup$LayoutParams;
    if-nez v7, :cond_d

    .line 1379
    new-instance v8, Landroid/view/ViewGroup$LayoutParams;

    const/4 v9, -0x2

    invoke-direct {v8, v9, v9}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    move-object v7, v8

    .line 1382
    :cond_d
    iget v8, v1, Landroid/support/v7/app/x$f;->b:I

    .line 1383
    .local v8, "backgroundResId":I
    iget-object v9, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    invoke-virtual {v9, v8}, Landroid/view/ViewGroup;->setBackgroundResource(I)V

    .line 1385
    iget-object v9, v1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    invoke-virtual {v9}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v9

    .line 1386
    .local v9, "shownPanelParent":Landroid/view/ViewParent;
    if-eqz v9, :cond_e

    instance-of v10, v9, Landroid/view/ViewGroup;

    if-eqz v10, :cond_e

    .line 1387
    move-object v10, v9

    check-cast v10, Landroid/view/ViewGroup;

    iget-object v11, v1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    invoke-virtual {v10, v11}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 1389
    :cond_e
    iget-object v10, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    iget-object v11, v1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    invoke-virtual {v10, v11, v7}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 1395
    iget-object v10, v1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->hasFocus()Z

    move-result v10

    if-nez v10, :cond_7

    .line 1396
    iget-object v10, v1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    invoke-virtual {v10}, Landroid/view/View;->requestFocus()Z

    goto :goto_1

    .line 1407
    .end local v7    # "lp":Landroid/view/ViewGroup$LayoutParams;
    .end local v8    # "backgroundResId":I
    .end local v9    # "shownPanelParent":Landroid/view/ViewParent;
    :cond_f
    :goto_3
    iput-boolean v3, v1, Landroid/support/v7/app/x$f;->n:Z

    .line 1409
    new-instance v3, Landroid/view/WindowManager$LayoutParams;

    const/4 v13, -0x2

    iget v14, v1, Landroid/support/v7/app/x$f;->d:I

    iget v15, v1, Landroid/support/v7/app/x$f;->e:I

    const/16 v16, 0x3ea

    const/high16 v17, 0x820000

    const/16 v18, -0x3

    move-object v11, v3

    move v12, v6

    invoke-direct/range {v11 .. v18}, Landroid/view/WindowManager$LayoutParams;-><init>(IIIIIII)V

    .line 1416
    .local v3, "lp":Landroid/view/WindowManager$LayoutParams;
    iget v7, v1, Landroid/support/v7/app/x$f;->c:I

    iput v7, v3, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 1417
    iget v7, v1, Landroid/support/v7/app/x$f;->f:I

    iput v7, v3, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    .line 1419
    iget-object v7, v1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    invoke-interface {v5, v7, v3}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 1420
    iput-boolean v4, v1, Landroid/support/v7/app/x$f;->o:Z

    .line 1421
    return-void

    .line 1374
    .end local v3    # "lp":Landroid/view/WindowManager$LayoutParams;
    :cond_10
    :goto_4
    return-void

    .line 1330
    .end local v2    # "cb":Landroid/view/Window$Callback;
    .end local v5    # "wm":Landroid/view/WindowManager;
    .end local v6    # "width":I
    :cond_11
    :goto_5
    return-void
.end method

.method private a(Landroid/support/v7/view/menu/l;Z)V
    .locals 6
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "toggleMenuMode"    # Z

    .line 1431
    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eqz v0, :cond_5

    invoke-interface {v0}, Landroid/support/v7/widget/K;->c()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 1432
    invoke-static {v0}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->hasPermanentMenuKey()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    .line 1433
    invoke-interface {v0}, Landroid/support/v7/widget/K;->d()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1435
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v0

    .line 1437
    .local v0, "cb":Landroid/view/Window$Callback;
    iget-object v3, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v3}, Landroid/support/v7/widget/K;->a()Z

    move-result v3

    const/16 v4, 0x6c

    if-eqz v3, :cond_2

    if-nez p2, :cond_1

    goto :goto_0

    .line 1457
    :cond_1
    iget-object v3, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v3}, Landroid/support/v7/widget/K;->e()Z

    .line 1458
    iget-boolean v3, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v3, :cond_4

    .line 1459
    invoke-virtual {p0, v2, v1}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 1460
    .local v1, "st":Landroid/support/v7/app/x$f;
    iget-object v2, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, v4, v2}, Landroid/view/Window$Callback;->onPanelClosed(ILandroid/view/Menu;)V

    goto :goto_1

    .line 1438
    .end local v1    # "st":Landroid/support/v7/app/x$f;
    :cond_2
    :goto_0
    if-eqz v0, :cond_4

    iget-boolean v3, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v3, :cond_4

    .line 1440
    iget-boolean v3, p0, Landroid/support/v7/app/x;->O:Z

    if-eqz v3, :cond_3

    iget v3, p0, Landroid/support/v7/app/x;->P:I

    and-int/2addr v3, v1

    if-eqz v3, :cond_3

    .line 1442
    iget-object v3, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v3}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v3

    iget-object v5, p0, Landroid/support/v7/app/x;->Q:Ljava/lang/Runnable;

    invoke-virtual {v3, v5}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1443
    iget-object v3, p0, Landroid/support/v7/app/x;->Q:Ljava/lang/Runnable;

    invoke-interface {v3}, Ljava/lang/Runnable;->run()V

    .line 1446
    :cond_3
    invoke-virtual {p0, v2, v1}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 1450
    .restart local v1    # "st":Landroid/support/v7/app/x$f;
    iget-object v3, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-eqz v3, :cond_4

    iget-boolean v5, v1, Landroid/support/v7/app/x$f;->r:Z

    if-nez v5, :cond_4

    iget-object v5, v1, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    .line 1451
    invoke-interface {v0, v2, v5, v3}, Landroid/view/Window$Callback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1452
    iget-object v2, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, v4, v2}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 1453
    iget-object v2, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v2}, Landroid/support/v7/widget/K;->f()Z

    .line 1463
    .end local v1    # "st":Landroid/support/v7/app/x$f;
    :cond_4
    :goto_1
    return-void

    .line 1466
    .end local v0    # "cb":Landroid/view/Window$Callback;
    :cond_5
    invoke-virtual {p0, v2, v1}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v0

    .line 1468
    .local v0, "st":Landroid/support/v7/app/x$f;
    iput-boolean v1, v0, Landroid/support/v7/app/x$f;->q:Z

    .line 1469
    invoke-virtual {p0, v0, v2}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1471
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)V

    .line 1472
    return-void
.end method

.method private a(Landroid/support/v7/app/x$f;)Z
    .locals 4
    .param p1, "st"    # Landroid/support/v7/app/x$f;

    .line 1518
    iget-object v0, p1, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 1519
    iput-object v0, p1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    .line 1520
    return v1

    .line 1523
    :cond_0
    iget-object v0, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    const/4 v2, 0x0

    if-nez v0, :cond_1

    .line 1524
    return v2

    .line 1527
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x;->o:Landroid/support/v7/app/x$g;

    if-nez v0, :cond_2

    .line 1528
    new-instance v0, Landroid/support/v7/app/x$g;

    invoke-direct {v0, p0}, Landroid/support/v7/app/x$g;-><init>(Landroid/support/v7/app/x;)V

    iput-object v0, p0, Landroid/support/v7/app/x;->o:Landroid/support/v7/app/x$g;

    .line 1531
    :cond_2
    iget-object v0, p0, Landroid/support/v7/app/x;->o:Landroid/support/v7/app/x$g;

    invoke-virtual {p1, v0}, Landroid/support/v7/app/x$f;->a(Landroid/support/v7/view/menu/v$a;)Landroid/support/v7/view/menu/w;

    move-result-object v0

    .line 1533
    .local v0, "menuView":Landroid/support/v7/view/menu/w;
    move-object v3, v0

    check-cast v3, Landroid/view/View;

    iput-object v3, p1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    .line 1535
    iget-object v3, p1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    if-eqz v3, :cond_3

    goto :goto_0

    :cond_3
    const/4 v1, 0x0

    :goto_0
    return v1
.end method

.method private a(Landroid/support/v7/app/x$f;ILandroid/view/KeyEvent;I)Z
    .locals 2
    .param p1, "st"    # Landroid/support/v7/app/x$f;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;
    .param p4, "flags"    # I

    .line 1815
    invoke-virtual {p3}, Landroid/view/KeyEvent;->isSystem()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1816
    const/4 v0, 0x0

    return v0

    .line 1819
    :cond_0
    const/4 v0, 0x0

    .line 1823
    .local v0, "handled":Z
    iget-boolean v1, p1, Landroid/support/v7/app/x$f;->m:Z

    if-nez v1, :cond_1

    invoke-direct {p0, p1, p3}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    iget-object v1, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-eqz v1, :cond_2

    .line 1825
    invoke-virtual {v1, p2, p3, p4}, Landroid/support/v7/view/menu/l;->performShortcut(ILandroid/view/KeyEvent;I)Z

    move-result v0

    .line 1828
    :cond_2
    if-eqz v0, :cond_3

    .line 1830
    and-int/lit8 v1, p4, 0x1

    if-nez v1, :cond_3

    iget-object v1, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-nez v1, :cond_3

    .line 1831
    const/4 v1, 0x1

    invoke-virtual {p0, p1, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1835
    :cond_3
    return v0
.end method

.method private a(Landroid/view/ViewParent;)Z
    .locals 3
    .param p1, "parent"    # Landroid/view/ViewParent;

    .line 1274
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 1276
    return v0

    .line 1278
    :cond_0
    iget-object v1, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    .line 1280
    .local v1, "windowDecor":Landroid/view/View;
    :goto_0
    if-nez p1, :cond_1

    .line 1285
    const/4 v0, 0x1

    return v0

    .line 1286
    :cond_1
    if-eq p1, v1, :cond_3

    instance-of v2, p1, Landroid/view/View;

    if-eqz v2, :cond_3

    move-object v2, p1

    check-cast v2, Landroid/view/View;

    .line 1287
    invoke-static {v2}, La/b/c/g/u;->j(Landroid/view/View;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_1

    .line 1294
    :cond_2
    invoke-interface {p1}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object p1

    goto :goto_0

    .line 1292
    :cond_3
    :goto_1
    return v0
.end method

.method private b(Landroid/support/v7/app/x$f;)Z
    .locals 2
    .param p1, "st"    # Landroid/support/v7/app/x$f;

    .line 1424
    invoke-virtual {p0}, Landroid/support/v7/app/x;->m()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/support/v7/app/x$f;->a(Landroid/content/Context;)V

    .line 1425
    new-instance v0, Landroid/support/v7/app/x$e;

    iget-object v1, p1, Landroid/support/v7/app/x$f;->l:Landroid/content/Context;

    invoke-direct {v0, p0, v1}, Landroid/support/v7/app/x$e;-><init>(Landroid/support/v7/app/x;Landroid/content/Context;)V

    iput-object v0, p1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    .line 1426
    const/16 v0, 0x51

    iput v0, p1, Landroid/support/v7/app/x$f;->c:I

    .line 1427
    const/4 v0, 0x1

    return v0
.end method

.method private b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z
    .locals 8
    .param p1, "st"    # Landroid/support/v7/app/x$f;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1539
    iget-boolean v0, p0, Landroid/support/v7/app/x;->K:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 1540
    return v1

    .line 1544
    :cond_0
    iget-boolean v0, p1, Landroid/support/v7/app/x$f;->m:Z

    const/4 v2, 0x1

    if-eqz v0, :cond_1

    .line 1545
    return v2

    .line 1548
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    if-eqz v0, :cond_2

    if-eq v0, p1, :cond_2

    .line 1550
    invoke-virtual {p0, v0, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1553
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v0

    .line 1555
    .local v0, "cb":Landroid/view/Window$Callback;
    if-eqz v0, :cond_3

    .line 1556
    iget v3, p1, Landroid/support/v7/app/x$f;->a:I

    invoke-interface {v0, v3}, Landroid/view/Window$Callback;->onCreatePanelView(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p1, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    .line 1559
    :cond_3
    iget v3, p1, Landroid/support/v7/app/x$f;->a:I

    if-eqz v3, :cond_5

    const/16 v4, 0x6c

    if-ne v3, v4, :cond_4

    goto :goto_0

    :cond_4
    const/4 v3, 0x0

    goto :goto_1

    :cond_5
    :goto_0
    const/4 v3, 0x1

    .line 1562
    .local v3, "isActionBarMenu":Z
    :goto_1
    if-eqz v3, :cond_6

    iget-object v4, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v4, :cond_6

    .line 1565
    invoke-interface {v4}, Landroid/support/v7/widget/K;->b()V

    .line 1568
    :cond_6
    iget-object v4, p1, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    if-nez v4, :cond_15

    if-eqz v3, :cond_7

    .line 1569
    invoke-virtual {p0}, Landroid/support/v7/app/x;->r()Landroid/support/v7/app/a;

    .line 1572
    :cond_7
    iget-object v4, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    const/4 v5, 0x0

    if-eqz v4, :cond_8

    iget-boolean v4, p1, Landroid/support/v7/app/x$f;->r:Z

    if-eqz v4, :cond_f

    .line 1573
    :cond_8
    iget-object v4, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-nez v4, :cond_a

    .line 1574
    invoke-direct {p0, p1}, Landroid/support/v7/app/x;->c(Landroid/support/v7/app/x$f;)Z

    move-result v4

    if-eqz v4, :cond_9

    iget-object v4, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-nez v4, :cond_a

    .line 1575
    :cond_9
    return v1

    .line 1579
    :cond_a
    if-eqz v3, :cond_c

    iget-object v4, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v4, :cond_c

    .line 1580
    iget-object v4, p0, Landroid/support/v7/app/x;->n:Landroid/support/v7/app/x$a;

    if-nez v4, :cond_b

    .line 1581
    new-instance v4, Landroid/support/v7/app/x$a;

    invoke-direct {v4, p0}, Landroid/support/v7/app/x$a;-><init>(Landroid/support/v7/app/x;)V

    iput-object v4, p0, Landroid/support/v7/app/x;->n:Landroid/support/v7/app/x$a;

    .line 1583
    :cond_b
    iget-object v4, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    iget-object v6, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    iget-object v7, p0, Landroid/support/v7/app/x;->n:Landroid/support/v7/app/x$a;

    invoke-interface {v4, v6, v7}, Landroid/support/v7/widget/K;->a(Landroid/view/Menu;Landroid/support/v7/view/menu/v$a;)V

    .line 1588
    :cond_c
    iget-object v4, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v4}, Landroid/support/v7/view/menu/l;->s()V

    .line 1589
    iget v4, p1, Landroid/support/v7/app/x$f;->a:I

    iget-object v6, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, v4, v6}, Landroid/view/Window$Callback;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v4

    if-nez v4, :cond_e

    .line 1591
    invoke-virtual {p1, v5}, Landroid/support/v7/app/x$f;->a(Landroid/support/v7/view/menu/l;)V

    .line 1593
    if-eqz v3, :cond_d

    iget-object v2, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v2, :cond_d

    .line 1595
    iget-object v4, p0, Landroid/support/v7/app/x;->n:Landroid/support/v7/app/x$a;

    invoke-interface {v2, v5, v4}, Landroid/support/v7/widget/K;->a(Landroid/view/Menu;Landroid/support/v7/view/menu/v$a;)V

    .line 1598
    :cond_d
    return v1

    .line 1601
    :cond_e
    iput-boolean v1, p1, Landroid/support/v7/app/x$f;->r:Z

    .line 1606
    :cond_f
    iget-object v4, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v4}, Landroid/support/v7/view/menu/l;->s()V

    .line 1610
    iget-object v4, p1, Landroid/support/v7/app/x$f;->s:Landroid/os/Bundle;

    if-eqz v4, :cond_10

    .line 1611
    iget-object v6, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v6, v4}, Landroid/support/v7/view/menu/l;->a(Landroid/os/Bundle;)V

    .line 1612
    iput-object v5, p1, Landroid/support/v7/app/x$f;->s:Landroid/os/Bundle;

    .line 1616
    :cond_10
    iget-object v4, p1, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    iget-object v6, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-interface {v0, v1, v4, v6}, Landroid/view/Window$Callback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v4

    if-nez v4, :cond_12

    .line 1617
    if-eqz v3, :cond_11

    iget-object v2, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v2, :cond_11

    .line 1620
    iget-object v4, p0, Landroid/support/v7/app/x;->n:Landroid/support/v7/app/x$a;

    invoke-interface {v2, v5, v4}, Landroid/support/v7/widget/K;->a(Landroid/view/Menu;Landroid/support/v7/view/menu/v$a;)V

    .line 1622
    :cond_11
    iget-object v2, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v2}, Landroid/support/v7/view/menu/l;->r()V

    .line 1623
    return v1

    .line 1627
    :cond_12
    if-eqz p2, :cond_13

    .line 1628
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getDeviceId()I

    move-result v4

    goto :goto_2

    :cond_13
    const/4 v4, -0x1

    .line 1627
    :goto_2
    invoke-static {v4}, Landroid/view/KeyCharacterMap;->load(I)Landroid/view/KeyCharacterMap;

    move-result-object v4

    .line 1629
    .local v4, "kmap":Landroid/view/KeyCharacterMap;
    invoke-virtual {v4}, Landroid/view/KeyCharacterMap;->getKeyboardType()I

    move-result v5

    if-eq v5, v2, :cond_14

    const/4 v5, 0x1

    goto :goto_3

    :cond_14
    const/4 v5, 0x0

    :goto_3
    iput-boolean v5, p1, Landroid/support/v7/app/x$f;->p:Z

    .line 1630
    iget-object v5, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    iget-boolean v6, p1, Landroid/support/v7/app/x$f;->p:Z

    invoke-virtual {v5, v6}, Landroid/support/v7/view/menu/l;->setQwertyMode(Z)V

    .line 1631
    iget-object v5, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v5}, Landroid/support/v7/view/menu/l;->r()V

    .line 1635
    .end local v4    # "kmap":Landroid/view/KeyCharacterMap;
    :cond_15
    iput-boolean v2, p1, Landroid/support/v7/app/x$f;->m:Z

    .line 1636
    iput-boolean v1, p1, Landroid/support/v7/app/x$f;->n:Z

    .line 1637
    iput-object p1, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    .line 1639
    return v2
.end method

.method private c(Landroid/support/v7/app/x$f;)Z
    .locals 7
    .param p1, "st"    # Landroid/support/v7/app/x$f;

    .line 1475
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 1478
    .local v0, "context":Landroid/content/Context;
    iget v1, p1, Landroid/support/v7/app/x$f;->a:I

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    const/16 v3, 0x6c

    if-ne v1, v3, :cond_4

    :cond_0
    iget-object v1, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v1, :cond_4

    .line 1480
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 1481
    .local v1, "outValue":Landroid/util/TypedValue;
    invoke-virtual {v0}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v3

    .line 1482
    .local v3, "baseTheme":Landroid/content/res/Resources$Theme;
    sget v4, La/b/d/a/a;->actionBarTheme:I

    invoke-virtual {v3, v4, v1, v2}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 1484
    const/4 v4, 0x0

    .line 1485
    .local v4, "widgetTheme":Landroid/content/res/Resources$Theme;
    iget v5, v1, Landroid/util/TypedValue;->resourceId:I

    if-eqz v5, :cond_1

    .line 1486
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    .line 1487
    invoke-virtual {v4, v3}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 1488
    iget v5, v1, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v4, v5, v2}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 1489
    sget v5, La/b/d/a/a;->actionBarWidgetTheme:I

    invoke-virtual {v4, v5, v1, v2}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    goto :goto_0

    .line 1492
    :cond_1
    sget v5, La/b/d/a/a;->actionBarWidgetTheme:I

    invoke-virtual {v3, v5, v1, v2}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 1496
    :goto_0
    iget v5, v1, Landroid/util/TypedValue;->resourceId:I

    if-eqz v5, :cond_3

    .line 1497
    if-nez v4, :cond_2

    .line 1498
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v4

    .line 1499
    invoke-virtual {v4, v3}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 1501
    :cond_2
    iget v5, v1, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v4, v5, v2}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 1504
    :cond_3
    if-eqz v4, :cond_4

    .line 1505
    new-instance v5, La/b/d/d/d;

    const/4 v6, 0x0

    invoke-direct {v5, v0, v6}, La/b/d/d/d;-><init>(Landroid/content/Context;I)V

    move-object v0, v5

    .line 1506
    invoke-virtual {v0}, La/b/d/d/d;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 1510
    .end local v1    # "outValue":Landroid/util/TypedValue;
    .end local v3    # "baseTheme":Landroid/content/res/Resources$Theme;
    .end local v4    # "widgetTheme":Landroid/content/res/Resources$Theme;
    :cond_4
    new-instance v1, Landroid/support/v7/view/menu/l;

    invoke-direct {v1, v0}, Landroid/support/v7/view/menu/l;-><init>(Landroid/content/Context;)V

    .line 1511
    .local v1, "menu":Landroid/support/v7/view/menu/l;
    invoke-virtual {v1, p0}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/l$a;)V

    .line 1512
    invoke-virtual {p1, v1}, Landroid/support/v7/app/x$f;->a(Landroid/support/v7/view/menu/l;)V

    .line 1514
    return v2
.end method

.method private d(ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "featureId"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1693
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 1694
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v0

    .line 1695
    .local v0, "st":Landroid/support/v7/app/x$f;
    iget-boolean v1, v0, Landroid/support/v7/app/x$f;->o:Z

    if-nez v1, :cond_0

    .line 1696
    invoke-direct {p0, v0, p2}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    move-result v1

    return v1

    .line 1700
    .end local v0    # "st":Landroid/support/v7/app/x$f;
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method private e(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "featureId"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1704
    iget-object v0, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 1705
    return v1

    .line 1708
    :cond_0
    const/4 v0, 0x0

    .line 1709
    .local v0, "handled":Z
    const/4 v2, 0x1

    invoke-virtual {p0, p1, v2}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v3

    .line 1710
    .local v3, "st":Landroid/support/v7/app/x$f;
    if-nez p1, :cond_2

    iget-object v4, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v4, :cond_2

    .line 1711
    invoke-interface {v4}, Landroid/support/v7/widget/K;->c()Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v4, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 1712
    invoke-static {v4}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/ViewConfiguration;->hasPermanentMenuKey()Z

    move-result v4

    if-nez v4, :cond_2

    .line 1713
    iget-object v2, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v2}, Landroid/support/v7/widget/K;->a()Z

    move-result v2

    if-nez v2, :cond_1

    .line 1714
    iget-boolean v2, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v2, :cond_6

    invoke-direct {p0, v3, p2}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1715
    iget-object v2, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v2}, Landroid/support/v7/widget/K;->f()Z

    move-result v0

    goto :goto_1

    .line 1718
    :cond_1
    iget-object v2, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v2}, Landroid/support/v7/widget/K;->e()Z

    move-result v0

    goto :goto_1

    .line 1721
    :cond_2
    iget-boolean v4, v3, Landroid/support/v7/app/x$f;->o:Z

    if-nez v4, :cond_5

    iget-boolean v4, v3, Landroid/support/v7/app/x$f;->n:Z

    if-eqz v4, :cond_3

    goto :goto_0

    .line 1727
    :cond_3
    iget-boolean v2, v3, Landroid/support/v7/app/x$f;->m:Z

    if-eqz v2, :cond_6

    .line 1728
    const/4 v2, 0x1

    .line 1729
    .local v2, "show":Z
    iget-boolean v4, v3, Landroid/support/v7/app/x$f;->r:Z

    if-eqz v4, :cond_4

    .line 1732
    iput-boolean v1, v3, Landroid/support/v7/app/x$f;->m:Z

    .line 1733
    invoke-direct {p0, v3, p2}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    move-result v2

    .line 1736
    :cond_4
    if-eqz v2, :cond_6

    .line 1738
    invoke-direct {p0, v3, p2}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)V

    .line 1739
    const/4 v0, 0x1

    goto :goto_1

    .line 1724
    .end local v2    # "show":Z
    :cond_5
    :goto_0
    iget-boolean v0, v3, Landroid/support/v7/app/x$f;->o:Z

    .line 1726
    invoke-virtual {p0, v3, v2}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1744
    :cond_6
    :goto_1
    if-eqz v0, :cond_8

    .line 1745
    iget-object v2, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    const-string v4, "audio"

    invoke-virtual {v2, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/media/AudioManager;

    .line 1747
    .local v2, "audioManager":Landroid/media/AudioManager;
    if-eqz v2, :cond_7

    .line 1748
    invoke-virtual {v2, v1}, Landroid/media/AudioManager;->playSoundEffect(I)V

    goto :goto_2

    .line 1750
    :cond_7
    const-string v1, "AppCompatDelegate"

    const-string v4, "Couldn\'t get audio manager"

    invoke-static {v1, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1753
    .end local v2    # "audioManager":Landroid/media/AudioManager;
    :cond_8
    :goto_2
    return v0
.end method

.method private j(I)V
    .locals 3
    .param p1, "featureId"    # I

    .line 1839
    iget v0, p0, Landroid/support/v7/app/x;->P:I

    const/4 v1, 0x1

    shl-int v2, v1, p1

    or-int/2addr v0, v2

    iput v0, p0, Landroid/support/v7/app/x;->P:I

    .line 1841
    iget-boolean v0, p0, Landroid/support/v7/app/x;->O:Z

    if-nez v0, :cond_0

    .line 1842
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v2, p0, Landroid/support/v7/app/x;->Q:Ljava/lang/Runnable;

    invoke-static {v0, v2}, La/b/c/g/u;->a(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 1843
    iput-boolean v1, p0, Landroid/support/v7/app/x;->O:Z

    .line 1845
    :cond_0
    return-void
.end method

.method private k(I)I
    .locals 2
    .param p1, "featureId"    # I

    .line 1958
    const-string v0, "AppCompatDelegate"

    const/16 v1, 0x8

    if-ne p1, v1, :cond_0

    .line 1959
    const-string v1, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1961
    const/16 v0, 0x6c

    return v0

    .line 1962
    :cond_0
    const/16 v1, 0x9

    if-ne p1, v1, :cond_1

    .line 1963
    const-string v1, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature."

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1965
    const/16 v0, 0x6d

    return v0

    .line 1968
    :cond_1
    return p1
.end method

.method private l(I)Z
    .locals 8
    .param p1, "mode"    # I

    .line 2074
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 2075
    .local v0, "res":Landroid/content/res/Resources;
    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 2076
    .local v1, "conf":Landroid/content/res/Configuration;
    iget v2, v1, Landroid/content/res/Configuration;->uiMode:I

    and-int/lit8 v2, v2, 0x30

    .line 2078
    .local v2, "currentNightMode":I
    const/4 v3, 0x2

    if-ne p1, v3, :cond_0

    const/16 v3, 0x20

    goto :goto_0

    :cond_0
    const/16 v3, 0x10

    .line 2082
    .local v3, "newNightMode":I
    :goto_0
    if-eq v2, v3, :cond_3

    .line 2083
    invoke-direct {p0}, Landroid/support/v7/app/x;->z()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2089
    iget-object v4, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    check-cast v4, Landroid/app/Activity;

    .line 2090
    .local v4, "activity":Landroid/app/Activity;
    invoke-virtual {v4}, Landroid/app/Activity;->recreate()V

    .line 2091
    .end local v4    # "activity":Landroid/app/Activity;
    goto :goto_1

    .line 2095
    :cond_1
    new-instance v4, Landroid/content/res/Configuration;

    invoke-direct {v4, v1}, Landroid/content/res/Configuration;-><init>(Landroid/content/res/Configuration;)V

    .line 2096
    .local v4, "config":Landroid/content/res/Configuration;
    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    .line 2099
    .local v5, "metrics":Landroid/util/DisplayMetrics;
    iget v6, v4, Landroid/content/res/Configuration;->uiMode:I

    and-int/lit8 v6, v6, -0x31

    or-int/2addr v6, v3

    iput v6, v4, Landroid/content/res/Configuration;->uiMode:I

    .line 2100
    invoke-virtual {v0, v4, v5}, Landroid/content/res/Resources;->updateConfiguration(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V

    .line 2103
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v7, 0x1a

    if-ge v6, v7, :cond_2

    .line 2104
    invoke-static {v0}, Landroid/support/v7/app/C;->a(Landroid/content/res/Resources;)V

    .line 2107
    .end local v4    # "config":Landroid/content/res/Configuration;
    .end local v5    # "metrics":Landroid/util/DisplayMetrics;
    :cond_2
    :goto_1
    const/4 v4, 0x1

    return v4

    .line 2113
    :cond_3
    const/4 v4, 0x0

    return v4
.end method

.method private t()V
    .locals 6

    .line 731
    iget-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/ContentFrameLayout;

    .line 737
    .local v0, "cfl":Landroid/support/v7/widget/ContentFrameLayout;
    iget-object v1, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    .line 738
    .local v1, "windowDecor":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getPaddingLeft()I

    move-result v2

    .line 739
    invoke-virtual {v1}, Landroid/view/View;->getPaddingTop()I

    move-result v3

    invoke-virtual {v1}, Landroid/view/View;->getPaddingRight()I

    move-result v4

    .line 740
    invoke-virtual {v1}, Landroid/view/View;->getPaddingBottom()I

    move-result v5

    .line 738
    invoke-virtual {v0, v2, v3, v4, v5}, Landroid/support/v7/widget/ContentFrameLayout;->a(IIII)V

    .line 742
    iget-object v2, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    sget-object v3, La/b/d/a/j;->AppCompatTheme:[I

    invoke-virtual {v2, v3}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 743
    .local v2, "a":Landroid/content/res/TypedArray;
    sget v3, La/b/d/a/j;->AppCompatTheme_windowMinWidthMajor:I

    invoke-virtual {v0}, Landroid/support/v7/widget/ContentFrameLayout;->getMinWidthMajor()Landroid/util/TypedValue;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 744
    sget v3, La/b/d/a/j;->AppCompatTheme_windowMinWidthMinor:I

    invoke-virtual {v0}, Landroid/support/v7/widget/ContentFrameLayout;->getMinWidthMinor()Landroid/util/TypedValue;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 746
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedWidthMajor:I

    invoke-virtual {v2, v3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 747
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedWidthMajor:I

    .line 748
    invoke-virtual {v0}, Landroid/support/v7/widget/ContentFrameLayout;->getFixedWidthMajor()Landroid/util/TypedValue;

    move-result-object v4

    .line 747
    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 750
    :cond_0
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedWidthMinor:I

    invoke-virtual {v2, v3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 751
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedWidthMinor:I

    .line 752
    invoke-virtual {v0}, Landroid/support/v7/widget/ContentFrameLayout;->getFixedWidthMinor()Landroid/util/TypedValue;

    move-result-object v4

    .line 751
    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 754
    :cond_1
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedHeightMajor:I

    invoke-virtual {v2, v3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 755
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedHeightMajor:I

    .line 756
    invoke-virtual {v0}, Landroid/support/v7/widget/ContentFrameLayout;->getFixedHeightMajor()Landroid/util/TypedValue;

    move-result-object v4

    .line 755
    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 758
    :cond_2
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedHeightMinor:I

    invoke-virtual {v2, v3}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 759
    sget v3, La/b/d/a/j;->AppCompatTheme_windowFixedHeightMinor:I

    .line 760
    invoke-virtual {v0}, Landroid/support/v7/widget/ContentFrameLayout;->getFixedHeightMinor()Landroid/util/TypedValue;

    move-result-object v4

    .line 759
    invoke-virtual {v2, v3, v4}, Landroid/content/res/TypedArray;->getValue(ILandroid/util/TypedValue;)Z

    .line 762
    :cond_3
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 764
    invoke-virtual {v0}, Landroid/widget/FrameLayout;->requestLayout()V

    .line 765
    return-void
.end method

.method private u()Landroid/view/ViewGroup;
    .locals 10

    .line 551
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    sget-object v1, La/b/d/a/j;->AppCompatTheme:[I

    invoke-virtual {v0, v1}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 553
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v1, La/b/d/a/j;->AppCompatTheme_windowActionBar:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 559
    sget v1, La/b/d/a/j;->AppCompatTheme_windowNoTitle:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    const/4 v3, 0x1

    if-eqz v1, :cond_0

    .line 560
    invoke-virtual {p0, v3}, Landroid/support/v7/app/x;->b(I)Z

    goto :goto_0

    .line 561
    :cond_0
    sget v1, La/b/d/a/j;->AppCompatTheme_windowActionBar:I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 563
    const/16 v1, 0x6c

    invoke-virtual {p0, v1}, Landroid/support/v7/app/x;->b(I)Z

    .line 565
    :cond_1
    :goto_0
    sget v1, La/b/d/a/j;->AppCompatTheme_windowActionBarOverlay:I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    const/16 v4, 0x6d

    if-eqz v1, :cond_2

    .line 566
    invoke-virtual {p0, v4}, Landroid/support/v7/app/x;->b(I)Z

    .line 568
    :cond_2
    sget v1, La/b/d/a/j;->AppCompatTheme_windowActionModeOverlay:I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 569
    const/16 v1, 0xa

    invoke-virtual {p0, v1}, Landroid/support/v7/app/x;->b(I)Z

    .line 571
    :cond_3
    sget v1, La/b/d/a/j;->AppCompatTheme_android_windowIsFloating:I

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Landroid/support/v7/app/x;->E:Z

    .line 572
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 575
    iget-object v1, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    .line 577
    iget-object v1, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 578
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const/4 v5, 0x0

    .line 581
    .local v5, "subDecor":Landroid/view/ViewGroup;
    iget-boolean v6, p0, Landroid/support/v7/app/x;->F:Z

    const/4 v7, 0x0

    if-nez v6, :cond_9

    .line 582
    iget-boolean v6, p0, Landroid/support/v7/app/x;->E:Z

    if-eqz v6, :cond_4

    .line 584
    sget v3, La/b/d/a/g;->abc_dialog_title_material:I

    invoke-virtual {v1, v3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    move-object v5, v3

    check-cast v5, Landroid/view/ViewGroup;

    .line 588
    iput-boolean v2, p0, Landroid/support/v7/app/x;->C:Z

    iput-boolean v2, p0, Landroid/support/v7/app/x;->B:Z

    goto/16 :goto_3

    .line 589
    :cond_4
    iget-boolean v6, p0, Landroid/support/v7/app/x;->B:Z

    if-eqz v6, :cond_c

    .line 595
    new-instance v6, Landroid/util/TypedValue;

    invoke-direct {v6}, Landroid/util/TypedValue;-><init>()V

    .line 596
    .local v6, "outValue":Landroid/util/TypedValue;
    iget-object v8, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v8

    sget v9, La/b/d/a/a;->actionBarTheme:I

    invoke-virtual {v8, v9, v6, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 599
    iget v3, v6, Landroid/util/TypedValue;->resourceId:I

    if-eqz v3, :cond_5

    .line 600
    new-instance v8, La/b/d/d/d;

    iget-object v9, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-direct {v8, v9, v3}, La/b/d/d/d;-><init>(Landroid/content/Context;I)V

    move-object v3, v8

    .local v3, "themedContext":Landroid/content/Context;
    goto :goto_1

    .line 602
    .end local v3    # "themedContext":Landroid/content/Context;
    :cond_5
    iget-object v3, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 606
    .restart local v3    # "themedContext":Landroid/content/Context;
    :goto_1
    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v8

    sget v9, La/b/d/a/g;->abc_screen_toolbar:I

    .line 607
    invoke-virtual {v8, v9, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    move-object v5, v8

    check-cast v5, Landroid/view/ViewGroup;

    .line 609
    sget v8, La/b/d/a/f;->decor_content_parent:I

    .line 610
    invoke-virtual {v5, v8}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/support/v7/widget/K;

    iput-object v8, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    .line 611
    iget-object v8, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-virtual {p0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v9

    invoke-interface {v8, v9}, Landroid/support/v7/widget/K;->setWindowCallback(Landroid/view/Window$Callback;)V

    .line 616
    iget-boolean v8, p0, Landroid/support/v7/app/x;->C:Z

    if-eqz v8, :cond_6

    .line 617
    iget-object v8, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v8, v4}, Landroid/support/v7/widget/K;->a(I)V

    .line 619
    :cond_6
    iget-boolean v4, p0, Landroid/support/v7/app/x;->z:Z

    if-eqz v4, :cond_7

    .line 620
    iget-object v4, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    const/4 v8, 0x2

    invoke-interface {v4, v8}, Landroid/support/v7/widget/K;->a(I)V

    .line 622
    :cond_7
    iget-boolean v4, p0, Landroid/support/v7/app/x;->A:Z

    if-eqz v4, :cond_8

    .line 623
    iget-object v4, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    const/4 v8, 0x5

    invoke-interface {v4, v8}, Landroid/support/v7/widget/K;->a(I)V

    .line 625
    .end local v3    # "themedContext":Landroid/content/Context;
    .end local v6    # "outValue":Landroid/util/TypedValue;
    :cond_8
    goto :goto_3

    .line 627
    :cond_9
    iget-boolean v3, p0, Landroid/support/v7/app/x;->D:Z

    if-eqz v3, :cond_a

    .line 628
    sget v3, La/b/d/a/g;->abc_screen_simple_overlay_action_mode:I

    invoke-virtual {v1, v3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    move-object v5, v3

    .end local v5    # "subDecor":Landroid/view/ViewGroup;
    .local v3, "subDecor":Landroid/view/ViewGroup;
    goto :goto_2

    .line 631
    .end local v3    # "subDecor":Landroid/view/ViewGroup;
    .restart local v5    # "subDecor":Landroid/view/ViewGroup;
    :cond_a
    sget v3, La/b/d/a/g;->abc_screen_simple:I

    invoke-virtual {v1, v3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    move-object v5, v3

    .line 634
    :goto_2
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x15

    if-lt v3, v4, :cond_b

    .line 637
    new-instance v3, Landroid/support/v7/app/r;

    invoke-direct {v3, p0}, Landroid/support/v7/app/r;-><init>(Landroid/support/v7/app/x;)V

    invoke-static {v5, v3}, La/b/c/g/u;->a(Landroid/view/View;La/b/c/g/q;)V

    goto :goto_3

    .line 659
    :cond_b
    move-object v3, v5

    check-cast v3, Landroid/support/v7/widget/O;

    new-instance v4, Landroid/support/v7/app/s;

    invoke-direct {v4, p0}, Landroid/support/v7/app/s;-><init>(Landroid/support/v7/app/x;)V

    invoke-interface {v3, v4}, Landroid/support/v7/widget/O;->setOnFitSystemWindowsListener(Landroid/support/v7/widget/O$a;)V

    .line 669
    :cond_c
    :goto_3
    if-eqz v5, :cond_10

    .line 680
    iget-object v3, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-nez v3, :cond_d

    .line 681
    sget v3, La/b/d/a/f;->title:I

    invoke-virtual {v5, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Landroid/support/v7/app/x;->x:Landroid/widget/TextView;

    .line 685
    :cond_d
    invoke-static {v5}, Landroid/support/v7/widget/Ha;->b(Landroid/view/View;)V

    .line 687
    sget v3, La/b/d/a/f;->action_bar_activity_content:I

    invoke-virtual {v5, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/support/v7/widget/ContentFrameLayout;

    .line 690
    .local v3, "contentView":Landroid/support/v7/widget/ContentFrameLayout;
    iget-object v4, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    const v6, 0x1020002

    invoke-virtual {v4, v6}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/view/ViewGroup;

    .line 691
    .local v4, "windowContentView":Landroid/view/ViewGroup;
    if-eqz v4, :cond_f

    .line 694
    :goto_4
    invoke-virtual {v4}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v8

    if-lez v8, :cond_e

    .line 695
    invoke-virtual {v4, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v8

    .line 696
    .local v8, "child":Landroid/view/View;
    invoke-virtual {v4, v2}, Landroid/view/ViewGroup;->removeViewAt(I)V

    .line 697
    invoke-virtual {v3, v8}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    .line 698
    .end local v8    # "child":Landroid/view/View;
    goto :goto_4

    .line 702
    :cond_e
    const/4 v2, -0x1

    invoke-virtual {v4, v2}, Landroid/view/ViewGroup;->setId(I)V

    .line 703
    invoke-virtual {v3, v6}, Landroid/widget/FrameLayout;->setId(I)V

    .line 707
    instance-of v2, v4, Landroid/widget/FrameLayout;

    if-eqz v2, :cond_f

    .line 708
    move-object v2, v4

    check-cast v2, Landroid/widget/FrameLayout;

    invoke-virtual {v2, v7}, Landroid/widget/FrameLayout;->setForeground(Landroid/graphics/drawable/Drawable;)V

    .line 713
    :cond_f
    iget-object v2, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v2, v5}, Landroid/view/Window;->setContentView(Landroid/view/View;)V

    .line 715
    new-instance v2, Landroid/support/v7/app/t;

    invoke-direct {v2, p0}, Landroid/support/v7/app/t;-><init>(Landroid/support/v7/app/x;)V

    invoke-virtual {v3, v2}, Landroid/support/v7/widget/ContentFrameLayout;->setAttachListener(Landroid/support/v7/widget/ContentFrameLayout$a;)V

    .line 725
    return-object v5

    .line 670
    .end local v3    # "contentView":Landroid/support/v7/widget/ContentFrameLayout;
    .end local v4    # "windowContentView":Landroid/view/ViewGroup;
    :cond_10
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "AppCompat does not support the current theme features: { windowActionBar: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-boolean v4, p0, Landroid/support/v7/app/x;->B:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v4, ", windowActionBarOverlay: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-boolean v4, p0, Landroid/support/v7/app/x;->C:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v4, ", android:windowIsFloating: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-boolean v4, p0, Landroid/support/v7/app/x;->E:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v4, ", windowActionModeOverlay: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-boolean v4, p0, Landroid/support/v7/app/x;->D:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v4, ", windowNoTitle: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-boolean v4, p0, Landroid/support/v7/app/x;->F:Z

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v4, " }"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 554
    .end local v1    # "inflater":Landroid/view/LayoutInflater;
    .end local v5    # "subDecor":Landroid/view/ViewGroup;
    :cond_11
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 555
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "You need to use a Theme.AppCompat theme (or descendant) with this activity."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    goto :goto_6

    :goto_5
    throw v1

    :goto_6
    goto :goto_5
.end method

.method private v()V
    .locals 2

    .line 2117
    iget-object v0, p0, Landroid/support/v7/app/x;->N:Landroid/support/v7/app/x$d;

    if-nez v0, :cond_0

    .line 2118
    new-instance v0, Landroid/support/v7/app/x$d;

    iget-object v1, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-static {v1}, Landroid/support/v7/app/E;->a(Landroid/content/Context;)Landroid/support/v7/app/E;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v7/app/x$d;-><init>(Landroid/support/v7/app/x;Landroid/support/v7/app/E;)V

    iput-object v0, p0, Landroid/support/v7/app/x;->N:Landroid/support/v7/app/x$d;

    .line 2120
    :cond_0
    return-void
.end method

.method private w()V
    .locals 3

    .line 517
    iget-boolean v0, p0, Landroid/support/v7/app/x;->v:Z

    if-nez v0, :cond_4

    .line 518
    invoke-direct {p0}, Landroid/support/v7/app/x;->u()Landroid/view/ViewGroup;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    .line 521
    invoke-virtual {p0}, Landroid/support/v7/app/x;->n()Ljava/lang/CharSequence;

    move-result-object v0

    .line 522
    .local v0, "title":Ljava/lang/CharSequence;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 523
    iget-object v1, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v1, :cond_0

    .line 524
    invoke-interface {v1, v0}, Landroid/support/v7/widget/K;->setWindowTitle(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 525
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/x;->r()Landroid/support/v7/app/a;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 526
    invoke-virtual {p0}, Landroid/support/v7/app/x;->r()Landroid/support/v7/app/a;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v7/app/a;->a(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 527
    :cond_1
    iget-object v1, p0, Landroid/support/v7/app/x;->x:Landroid/widget/TextView;

    if-eqz v1, :cond_2

    .line 528
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 532
    :cond_2
    :goto_0
    invoke-direct {p0}, Landroid/support/v7/app/x;->t()V

    .line 534
    iget-object v1, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    invoke-virtual {p0, v1}, Landroid/support/v7/app/x;->a(Landroid/view/ViewGroup;)V

    .line 536
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/app/x;->v:Z

    .line 543
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v1}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 544
    .local v1, "st":Landroid/support/v7/app/x$f;
    iget-boolean v2, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v2, :cond_4

    if-eqz v1, :cond_3

    iget-object v2, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-nez v2, :cond_4

    .line 545
    :cond_3
    const/16 v2, 0x6c

    invoke-direct {p0, v2}, Landroid/support/v7/app/x;->j(I)V

    .line 548
    .end local v0    # "title":Ljava/lang/CharSequence;
    .end local v1    # "st":Landroid/support/v7/app/x$f;
    :cond_4
    return-void
.end method

.method private x()I
    .locals 2

    .line 2066
    iget v0, p0, Landroid/support/v7/app/x;->L:I

    const/16 v1, -0x64

    if-eq v0, v1, :cond_0

    goto :goto_0

    :cond_0
    invoke-static {}, Landroid/support/v7/app/o;->b()I

    move-result v0

    :goto_0
    return v0
.end method

.method private y()V
    .locals 3

    .line 319
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 321
    iget-boolean v0, p0, Landroid/support/v7/app/x;->B:Z

    if-eqz v0, :cond_4

    iget-object v0, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    if-eqz v0, :cond_0

    goto :goto_1

    .line 325
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    instance-of v1, v0, Landroid/app/Activity;

    if-eqz v1, :cond_1

    .line 326
    new-instance v1, Landroid/support/v7/app/I;

    check-cast v0, Landroid/app/Activity;

    iget-boolean v2, p0, Landroid/support/v7/app/x;->C:Z

    invoke-direct {v1, v0, v2}, Landroid/support/v7/app/I;-><init>(Landroid/app/Activity;Z)V

    iput-object v1, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    goto :goto_0

    .line 328
    :cond_1
    instance-of v1, v0, Landroid/app/Dialog;

    if-eqz v1, :cond_2

    .line 329
    new-instance v1, Landroid/support/v7/app/I;

    check-cast v0, Landroid/app/Dialog;

    invoke-direct {v1, v0}, Landroid/support/v7/app/I;-><init>(Landroid/app/Dialog;)V

    iput-object v1, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    .line 331
    :cond_2
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    if-eqz v0, :cond_3

    .line 332
    iget-boolean v1, p0, Landroid/support/v7/app/x;->R:Z

    invoke-virtual {v0, v1}, Landroid/support/v7/app/a;->c(Z)V

    .line 334
    :cond_3
    return-void

    .line 322
    :cond_4
    :goto_1
    return-void
.end method

.method private z()Z
    .locals 6

    .line 2129
    iget-boolean v0, p0, Landroid/support/v7/app/x;->M:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    instance-of v2, v0, Landroid/app/Activity;

    if-eqz v2, :cond_1

    .line 2132
    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 2134
    .local v0, "pm":Landroid/content/pm/PackageManager;
    const/4 v2, 0x1

    :try_start_0
    new-instance v3, Landroid/content/ComponentName;

    iget-object v4, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    iget-object v5, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 2135
    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2134
    invoke-virtual {v0, v3, v1}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;

    move-result-object v3

    .line 2138
    .local v3, "info":Landroid/content/pm/ActivityInfo;
    iget v4, v3, Landroid/content/pm/ActivityInfo;->configChanges:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    and-int/lit16 v4, v4, 0x200

    if-nez v4, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1

    .line 2139
    .end local v3    # "info":Landroid/content/pm/ActivityInfo;
    :catch_0
    move-exception v1

    .line 2142
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string v3, "AppCompatDelegate"

    const-string v4, "Exception while getting ActivityInfo"

    invoke-static {v3, v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 2143
    return v2

    .line 2146
    .end local v0    # "pm":Landroid/content/pm/PackageManager;
    .end local v1    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    return v1
.end method


# virtual methods
.method public a(La/b/d/d/b$a;)La/b/d/d/b;
    .locals 4
    .param p1, "callback"    # La/b/d/d/b$a;

    .line 901
    if-eqz p1, :cond_3

    .line 905
    iget-object v0, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    if-eqz v0, :cond_0

    .line 906
    invoke-virtual {v0}, La/b/d/d/b;->a()V

    .line 909
    :cond_0
    new-instance v0, Landroid/support/v7/app/x$b;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/app/x$b;-><init>(Landroid/support/v7/app/x;La/b/d/d/b$a;)V

    .line 911
    .local v0, "wrappedCallback":La/b/d/d/b$a;
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v1

    .line 912
    .local v1, "ab":Landroid/support/v7/app/a;
    if-eqz v1, :cond_1

    .line 913
    invoke-virtual {v1, v0}, Landroid/support/v7/app/a;->a(La/b/d/d/b$a;)La/b/d/d/b;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    .line 914
    iget-object v2, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    if-eqz v2, :cond_1

    iget-object v3, p0, Landroid/support/v7/app/x;->i:Landroid/support/v7/app/n;

    if-eqz v3, :cond_1

    .line 915
    invoke-interface {v3, v2}, Landroid/support/v7/app/n;->b(La/b/d/d/b;)V

    .line 919
    :cond_1
    iget-object v2, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    if-nez v2, :cond_2

    .line 921
    invoke-virtual {p0, v0}, Landroid/support/v7/app/x;->b(La/b/d/d/b$a;)La/b/d/d/b;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    .line 924
    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    return-object v2

    .line 902
    .end local v0    # "wrappedCallback":La/b/d/d/b$a;
    .end local v1    # "ab":Landroid/support/v7/app/a;
    :cond_3
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "ActionMode callback can not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected a(IZ)Landroid/support/v7/app/x$f;
    .locals 4
    .param p1, "featureId"    # I
    .param p2, "required"    # Z

    .line 1798
    iget-object v0, p0, Landroid/support/v7/app/x;->H:[Landroid/support/v7/app/x$f;

    move-object v1, v0

    .local v1, "ar":[Landroid/support/v7/app/x$f;
    if-eqz v0, :cond_0

    array-length v0, v1

    if-gt v0, p1, :cond_2

    .line 1799
    :cond_0
    add-int/lit8 v0, p1, 0x1

    new-array v0, v0, [Landroid/support/v7/app/x$f;

    .line 1800
    .local v0, "nar":[Landroid/support/v7/app/x$f;
    if-eqz v1, :cond_1

    .line 1801
    array-length v2, v1

    const/4 v3, 0x0

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 1803
    :cond_1
    move-object v1, v0

    iput-object v0, p0, Landroid/support/v7/app/x;->H:[Landroid/support/v7/app/x$f;

    .line 1806
    .end local v0    # "nar":[Landroid/support/v7/app/x$f;
    :cond_2
    aget-object v0, v1, p1

    .line 1807
    .local v0, "st":Landroid/support/v7/app/x$f;
    if-nez v0, :cond_3

    .line 1808
    new-instance v2, Landroid/support/v7/app/x$f;

    invoke-direct {v2, p1}, Landroid/support/v7/app/x$f;-><init>(I)V

    move-object v0, v2

    aput-object v2, v1, p1

    .line 1810
    :cond_3
    return-object v0
.end method

.method a(Landroid/view/Menu;)Landroid/support/v7/app/x$f;
    .locals 5
    .param p1, "menu"    # Landroid/view/Menu;

    .line 1785
    iget-object v0, p0, Landroid/support/v7/app/x;->H:[Landroid/support/v7/app/x$f;

    .line 1786
    .local v0, "panels":[Landroid/support/v7/app/x$f;
    if-eqz v0, :cond_0

    array-length v1, v0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 1787
    .local v1, "N":I
    :goto_0
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v1, :cond_2

    .line 1788
    aget-object v3, v0, v2

    .line 1789
    .local v3, "panel":Landroid/support/v7/app/x$f;
    if-eqz v3, :cond_1

    iget-object v4, v3, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-ne v4, p1, :cond_1

    .line 1790
    return-object v3

    .line 1787
    .end local v3    # "panel":Landroid/support/v7/app/x$f;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 1793
    .end local v2    # "i":I
    :cond_2
    const/4 v2, 0x0

    return-object v2
.end method

.method public a(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/view/View;",
            ">(I)TT;"
        }
    .end annotation

    .line 403
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 404
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 10
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "attrs"    # Landroid/util/AttributeSet;

    .line 1234
    iget-object v0, p0, Landroid/support/v7/app/x;->U:Landroid/support/v7/app/AppCompatViewInflater;

    const/4 v1, 0x0

    if-nez v0, :cond_2

    .line 1235
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    sget-object v2, La/b/d/a/j;->AppCompatTheme:[I

    invoke-virtual {v0, v2}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 1236
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v2, La/b/d/a/j;->AppCompatTheme_viewInflaterClass:I

    .line 1237
    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1238
    .local v2, "viewInflaterClassName":Ljava/lang/String;
    if-eqz v2, :cond_1

    const-class v3, Landroid/support/v7/app/AppCompatViewInflater;

    .line 1239
    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    goto :goto_0

    .line 1245
    :cond_0
    :try_start_0
    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    .line 1246
    .local v3, "viewInflaterClass":Ljava/lang/Class;
    new-array v4, v1, [Ljava/lang/Class;

    .line 1247
    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v4

    new-array v5, v1, [Ljava/lang/Object;

    .line 1248
    invoke-virtual {v4, v5}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v7/app/AppCompatViewInflater;

    iput-object v4, p0, Landroid/support/v7/app/x;->U:Landroid/support/v7/app/AppCompatViewInflater;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 1253
    .end local v3    # "viewInflaterClass":Ljava/lang/Class;
    goto :goto_1

    .line 1249
    :catch_0
    move-exception v3

    .line 1250
    .local v3, "t":Ljava/lang/Throwable;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to instantiate custom view inflater "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, ". Falling back to default."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "AppCompatDelegate"

    invoke-static {v5, v4, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1252
    new-instance v4, Landroid/support/v7/app/AppCompatViewInflater;

    invoke-direct {v4}, Landroid/support/v7/app/AppCompatViewInflater;-><init>()V

    iput-object v4, p0, Landroid/support/v7/app/x;->U:Landroid/support/v7/app/AppCompatViewInflater;

    goto :goto_1

    .line 1242
    .end local v3    # "t":Ljava/lang/Throwable;
    :cond_1
    :goto_0
    new-instance v3, Landroid/support/v7/app/AppCompatViewInflater;

    invoke-direct {v3}, Landroid/support/v7/app/AppCompatViewInflater;-><init>()V

    iput-object v3, p0, Landroid/support/v7/app/x;->U:Landroid/support/v7/app/AppCompatViewInflater;

    .line 1257
    .end local v0    # "a":Landroid/content/res/TypedArray;
    .end local v2    # "viewInflaterClassName":Ljava/lang/String;
    :cond_2
    :goto_1
    const/4 v0, 0x0

    .line 1258
    .local v0, "inheritContext":Z
    sget-boolean v2, Landroid/support/v7/app/x;->b:Z

    if-eqz v2, :cond_5

    .line 1259
    instance-of v2, p4, Lorg/xmlpull/v1/XmlPullParser;

    const/4 v3, 0x1

    if-eqz v2, :cond_3

    move-object v2, p4

    check-cast v2, Lorg/xmlpull/v1/XmlPullParser;

    .line 1261
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    if-le v2, v3, :cond_4

    const/4 v1, 0x1

    goto :goto_2

    :cond_3
    move-object v1, p1

    check-cast v1, Landroid/view/ViewParent;

    .line 1263
    invoke-direct {p0, v1}, Landroid/support/v7/app/x;->a(Landroid/view/ViewParent;)Z

    move-result v1

    :cond_4
    :goto_2
    move v0, v1

    .line 1266
    :cond_5
    iget-object v1, p0, Landroid/support/v7/app/x;->U:Landroid/support/v7/app/AppCompatViewInflater;

    sget-boolean v7, Landroid/support/v7/app/x;->b:Z

    const/4 v8, 0x1

    .line 1269
    invoke-static {}, Landroid/support/v7/widget/Ga;->b()Z

    move-result v9

    .line 1266
    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move v6, v0

    invoke-virtual/range {v1 .. v9}, Landroid/support/v7/app/AppCompatViewInflater;->a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;ZZZZ)Landroid/view/View;

    move-result-object v1

    return-object v1
.end method

.method a(ILandroid/support/v7/app/x$f;Landroid/view/Menu;)V
    .locals 2
    .param p1, "featureId"    # I
    .param p2, "panel"    # Landroid/support/v7/app/x$f;
    .param p3, "menu"    # Landroid/view/Menu;

    .line 1758
    if-nez p3, :cond_1

    .line 1760
    if-nez p2, :cond_0

    .line 1761
    if-ltz p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/x;->H:[Landroid/support/v7/app/x$f;

    array-length v1, v0

    if-ge p1, v1, :cond_0

    .line 1762
    aget-object p2, v0, p1

    .line 1766
    :cond_0
    if-eqz p2, :cond_1

    .line 1768
    iget-object p3, p2, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    .line 1773
    :cond_1
    if-eqz p2, :cond_2

    iget-boolean v0, p2, Landroid/support/v7/app/x$f;->o:Z

    if-nez v0, :cond_2

    .line 1774
    return-void

    .line 1776
    :cond_2
    iget-boolean v0, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v0, :cond_3

    .line 1780
    iget-object v0, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    invoke-interface {v0, p1, p3}, Landroid/view/Window$Callback;->onPanelClosed(ILandroid/view/Menu;)V

    .line 1782
    :cond_3
    return-void
.end method

.method public a(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 411
    iget-boolean v0, p0, Landroid/support/v7/app/x;->B:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroid/support/v7/app/x;->v:Z

    if-eqz v0, :cond_0

    .line 414
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 415
    .local v0, "ab":Landroid/support/v7/app/a;
    if-eqz v0, :cond_0

    .line 416
    invoke-virtual {v0, p1}, Landroid/support/v7/app/a;->a(Landroid/content/res/Configuration;)V

    .line 421
    .end local v0    # "ab":Landroid/support/v7/app/a;
    :cond_0
    invoke-static {}, Landroid/support/v7/widget/o;->a()Landroid/support/v7/widget/o;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/o;->a(Landroid/content/Context;)V

    .line 424
    invoke-virtual {p0}, Landroid/support/v7/app/x;->a()Z

    .line 425
    return-void
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 269
    iget-object v0, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    instance-of v1, v0, Landroid/app/Activity;

    if-eqz v1, :cond_1

    .line 270
    const/4 v1, 0x0

    .line 272
    .local v1, "parentActivityName":Ljava/lang/String;
    :try_start_0
    check-cast v0, Landroid/app/Activity;

    invoke-static {v0}, Landroid/support/v4/app/T;->b(Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v1, v0

    .line 276
    goto :goto_0

    .line 274
    :catch_0
    move-exception v0

    .line 277
    :goto_0
    if-eqz v1, :cond_1

    .line 279
    invoke-virtual {p0}, Landroid/support/v7/app/x;->r()Landroid/support/v7/app/a;

    move-result-object v0

    .line 280
    .local v0, "ab":Landroid/support/v7/app/a;
    const/4 v2, 0x1

    if-nez v0, :cond_0

    .line 281
    iput-boolean v2, p0, Landroid/support/v7/app/x;->R:Z

    goto :goto_1

    .line 283
    :cond_0
    invoke-virtual {v0, v2}, Landroid/support/v7/app/a;->c(Z)V

    .line 288
    .end local v0    # "ab":Landroid/support/v7/app/a;
    .end local v1    # "parentActivityName":Ljava/lang/String;
    :cond_1
    :goto_1
    if-eqz p1, :cond_2

    iget v0, p0, Landroid/support/v7/app/x;->L:I

    const/16 v1, -0x64

    if-ne v0, v1, :cond_2

    .line 291
    const-string v0, "appcompat:local_night_mode"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Landroid/support/v7/app/x;->L:I

    .line 294
    :cond_2
    return-void
.end method

.method a(Landroid/support/v7/app/x$f;Z)V
    .locals 3
    .param p1, "st"    # Landroid/support/v7/app/x$f;
    .param p2, "doCallback"    # Z

    .line 1661
    if-eqz p2, :cond_0

    iget v0, p1, Landroid/support/v7/app/x$f;->a:I

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v0, :cond_0

    .line 1662
    invoke-interface {v0}, Landroid/support/v7/widget/K;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1663
    iget-object v0, p1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {p0, v0}, Landroid/support/v7/app/x;->b(Landroid/support/v7/view/menu/l;)V

    .line 1664
    return-void

    .line 1667
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 1668
    .local v0, "wm":Landroid/view/WindowManager;
    const/4 v1, 0x0

    if-eqz v0, :cond_1

    iget-boolean v2, p1, Landroid/support/v7/app/x$f;->o:Z

    if-eqz v2, :cond_1

    iget-object v2, p1, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    if-eqz v2, :cond_1

    .line 1669
    invoke-interface {v0, v2}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 1671
    if-eqz p2, :cond_1

    .line 1672
    iget v2, p1, Landroid/support/v7/app/x$f;->a:I

    invoke-virtual {p0, v2, p1, v1}, Landroid/support/v7/app/x;->a(ILandroid/support/v7/app/x$f;Landroid/view/Menu;)V

    .line 1676
    :cond_1
    const/4 v2, 0x0

    iput-boolean v2, p1, Landroid/support/v7/app/x$f;->m:Z

    .line 1677
    iput-boolean v2, p1, Landroid/support/v7/app/x$f;->n:Z

    .line 1678
    iput-boolean v2, p1, Landroid/support/v7/app/x$f;->o:Z

    .line 1681
    iput-object v1, p1, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    .line 1685
    const/4 v2, 0x1

    iput-boolean v2, p1, Landroid/support/v7/app/x$f;->q:Z

    .line 1687
    iget-object v2, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    if-ne v2, p1, :cond_2

    .line 1688
    iput-object v1, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    .line 1690
    :cond_2
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;

    .line 896
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/support/v7/app/x;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 897
    return-void
.end method

.method public a(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .line 457
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 458
    iget-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 459
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 460
    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 461
    iget-object v1, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    invoke-interface {v1}, Landroid/view/Window$Callback;->onContentChanged()V

    .line 462
    return-void
.end method

.method public a(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "lp"    # Landroid/view/ViewGroup$LayoutParams;

    .line 484
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 485
    iget-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 486
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0, p1, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 487
    iget-object v1, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    invoke-interface {v1}, Landroid/view/Window$Callback;->onContentChanged()V

    .line 488
    return-void
.end method

.method a(Landroid/view/ViewGroup;)V
    .locals 0
    .param p1, "subDecor"    # Landroid/view/ViewGroup;

    .line 728
    return-void
.end method

.method public final a(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 837
    iput-object p1, p0, Landroid/support/v7/app/x;->l:Ljava/lang/CharSequence;

    .line 839
    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v0, :cond_0

    .line 840
    invoke-interface {v0, p1}, Landroid/support/v7/widget/K;->setWindowTitle(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 841
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/x;->r()Landroid/support/v7/app/a;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 842
    invoke-virtual {p0}, Landroid/support/v7/app/x;->r()Landroid/support/v7/app/a;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/a;->a(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 843
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x;->x:Landroid/widget/TextView;

    if-eqz v0, :cond_2

    .line 844
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 846
    :cond_2
    :goto_0
    return-void
.end method

.method public a()Z
    .locals 4

    .line 2002
    const/4 v0, 0x0

    .line 2004
    .local v0, "applied":Z
    invoke-direct {p0}, Landroid/support/v7/app/x;->x()I

    move-result v1

    .line 2005
    .local v1, "nightMode":I
    invoke-virtual {p0, v1}, Landroid/support/v7/app/x;->f(I)I

    move-result v2

    .line 2006
    .local v2, "modeToApply":I
    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 2007
    invoke-direct {p0, v2}, Landroid/support/v7/app/x;->l(I)Z

    move-result v0

    .line 2010
    :cond_0
    if-nez v1, :cond_1

    .line 2012
    invoke-direct {p0}, Landroid/support/v7/app/x;->v()V

    .line 2013
    iget-object v3, p0, Landroid/support/v7/app/x;->N:Landroid/support/v7/app/x$d;

    invoke-virtual {v3}, Landroid/support/v7/app/x$d;->d()V

    .line 2016
    :cond_1
    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/support/v7/app/x;->M:Z

    .line 2017
    return v0
.end method

.method a(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1215
    const/4 v0, 0x4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eq p1, v0, :cond_1

    const/16 v0, 0x52

    if-eq p1, v0, :cond_0

    goto :goto_1

    .line 1217
    :cond_0
    invoke-direct {p0, v2, p2}, Landroid/support/v7/app/x;->d(ILandroid/view/KeyEvent;)Z

    .line 1221
    return v1

    .line 1225
    :cond_1
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getFlags()I

    move-result v0

    and-int/lit16 v0, v0, 0x80

    if-eqz v0, :cond_2

    goto :goto_0

    :cond_2
    const/4 v1, 0x0

    :goto_0
    iput-boolean v1, p0, Landroid/support/v7/app/x;->J:Z

    .line 1228
    :goto_1
    return v2
.end method

.method public a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)Z
    .locals 3
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 884
    invoke-virtual {p0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v0

    .line 885
    .local v0, "cb":Landroid/view/Window$Callback;
    if-eqz v0, :cond_0

    iget-boolean v1, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v1, :cond_0

    .line 886
    invoke-virtual {p1}, Landroid/support/v7/view/menu/l;->m()Landroid/support/v7/view/menu/l;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/support/v7/app/x;->a(Landroid/view/Menu;)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 887
    .local v1, "panel":Landroid/support/v7/app/x$f;
    if-eqz v1, :cond_0

    .line 888
    iget v2, v1, Landroid/support/v7/app/x$f;->a:I

    invoke-interface {v0, v2, p2}, Landroid/view/Window$Callback;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v2

    return v2

    .line 891
    .end local v1    # "panel":Landroid/support/v7/app/x$f;
    :cond_0
    const/4 v1, 0x0

    return v1
.end method

.method a(Landroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 1165
    iget-object v0, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    instance-of v1, v0, La/b/c/g/g$a;

    const/4 v2, 0x1

    if-nez v1, :cond_0

    instance-of v0, v0, Landroid/support/v7/app/B;

    if-eqz v0, :cond_1

    .line 1167
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 1168
    .local v0, "root":Landroid/view/View;
    if-eqz v0, :cond_1

    invoke-static {v0, p1}, La/b/c/g/g;->a(Landroid/view/View;Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1169
    return v2

    .line 1173
    .end local v0    # "root":Landroid/view/View;
    :cond_1
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    const/16 v1, 0x52

    if-ne v0, v1, :cond_2

    .line 1175
    iget-object v0, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1176
    return v2

    .line 1180
    :cond_2
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    .line 1181
    .local v0, "keyCode":I
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    .line 1182
    .local v1, "action":I
    if-nez v1, :cond_3

    goto :goto_0

    :cond_3
    const/4 v2, 0x0

    .line 1184
    .local v2, "isDown":Z
    :goto_0
    if-eqz v2, :cond_4

    invoke-virtual {p0, v0, p1}, Landroid/support/v7/app/x;->a(ILandroid/view/KeyEvent;)Z

    move-result v3

    goto :goto_1

    :cond_4
    invoke-virtual {p0, v0, p1}, Landroid/support/v7/app/x;->c(ILandroid/view/KeyEvent;)Z

    move-result v3

    :goto_1
    return v3
.end method

.method b(La/b/d/d/b$a;)La/b/d/d/b;
    .locals 10
    .param p1, "callback"    # La/b/d/d/b$a;

    .line 936
    invoke-virtual {p0}, Landroid/support/v7/app/x;->l()V

    .line 937
    iget-object v0, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    if-eqz v0, :cond_0

    .line 938
    invoke-virtual {v0}, La/b/d/d/b;->a()V

    .line 941
    :cond_0
    instance-of v0, p1, Landroid/support/v7/app/x$b;

    if-nez v0, :cond_1

    .line 943
    new-instance v0, Landroid/support/v7/app/x$b;

    invoke-direct {v0, p0, p1}, Landroid/support/v7/app/x$b;-><init>(Landroid/support/v7/app/x;La/b/d/d/b$a;)V

    move-object p1, v0

    .line 946
    :cond_1
    const/4 v0, 0x0

    .line 947
    .local v0, "mode":La/b/d/d/b;
    iget-object v1, p0, Landroid/support/v7/app/x;->i:Landroid/support/v7/app/n;

    if-eqz v1, :cond_2

    iget-boolean v2, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v2, :cond_2

    .line 949
    :try_start_0
    invoke-interface {v1, p1}, Landroid/support/v7/app/n;->a(La/b/d/d/b$a;)La/b/d/d/b;

    move-result-object v1
    :try_end_0
    .catch Ljava/lang/AbstractMethodError; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    .line 952
    goto :goto_0

    .line 950
    :catch_0
    move-exception v1

    .line 955
    :cond_2
    :goto_0
    if-eqz v0, :cond_3

    .line 956
    iput-object v0, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    goto/16 :goto_5

    .line 958
    :cond_3
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-nez v1, :cond_6

    .line 959
    iget-boolean v1, p0, Landroid/support/v7/app/x;->E:Z

    if-eqz v1, :cond_5

    .line 961
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 962
    .local v1, "outValue":Landroid/util/TypedValue;
    iget-object v5, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v5

    .line 963
    .local v5, "baseTheme":Landroid/content/res/Resources$Theme;
    sget v6, La/b/d/a/a;->actionBarTheme:I

    invoke-virtual {v5, v6, v1, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 966
    iget v6, v1, Landroid/util/TypedValue;->resourceId:I

    if-eqz v6, :cond_4

    .line 967
    iget-object v6, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v6

    .line 968
    .local v6, "actionBarTheme":Landroid/content/res/Resources$Theme;
    invoke-virtual {v6, v5}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 969
    iget v7, v1, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {v6, v7, v4}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 971
    new-instance v7, La/b/d/d/d;

    iget-object v8, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-direct {v7, v8, v3}, La/b/d/d/d;-><init>(Landroid/content/Context;I)V

    .line 972
    .local v7, "actionBarContext":Landroid/content/Context;
    invoke-virtual {v7}, La/b/d/d/d;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v8

    invoke-virtual {v8, v6}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 973
    .end local v6    # "actionBarTheme":Landroid/content/res/Resources$Theme;
    goto :goto_1

    .line 974
    .end local v7    # "actionBarContext":Landroid/content/Context;
    :cond_4
    iget-object v7, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 977
    .restart local v7    # "actionBarContext":Landroid/content/Context;
    :goto_1
    new-instance v6, Landroid/support/v7/widget/ActionBarContextView;

    invoke-direct {v6, v7}, Landroid/support/v7/widget/ActionBarContextView;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    .line 978
    new-instance v6, Landroid/widget/PopupWindow;

    sget v8, La/b/d/a/a;->actionModePopupWindowStyle:I

    invoke-direct {v6, v7, v2, v8}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput-object v6, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    .line 980
    iget-object v6, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    const/4 v8, 0x2

    invoke-static {v6, v8}, Landroid/support/v4/widget/k;->a(Landroid/widget/PopupWindow;I)V

    .line 982
    iget-object v6, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    iget-object v8, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v6, v8}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 983
    iget-object v6, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    const/4 v8, -0x1

    invoke-virtual {v6, v8}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 985
    invoke-virtual {v7}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v6

    sget v8, La/b/d/a/a;->actionBarSize:I

    invoke-virtual {v6, v8, v1, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 987
    iget v6, v1, Landroid/util/TypedValue;->data:I

    .line 988
    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    .line 987
    invoke-static {v6, v8}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v6

    .line 989
    .local v6, "height":I
    iget-object v8, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v8, v6}, Landroid/support/v7/widget/ActionBarContextView;->setContentHeight(I)V

    .line 990
    iget-object v8, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    const/4 v9, -0x2

    invoke-virtual {v8, v9}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 991
    new-instance v8, Landroid/support/v7/app/v;

    invoke-direct {v8, p0}, Landroid/support/v7/app/v;-><init>(Landroid/support/v7/app/x;)V

    iput-object v8, p0, Landroid/support/v7/app/x;->s:Ljava/lang/Runnable;

    .line 1021
    .end local v1    # "outValue":Landroid/util/TypedValue;
    .end local v5    # "baseTheme":Landroid/content/res/Resources$Theme;
    .end local v6    # "height":I
    .end local v7    # "actionBarContext":Landroid/content/Context;
    goto :goto_2

    .line 1022
    :cond_5
    iget-object v1, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    sget v5, La/b/d/a/f;->action_mode_bar_stub:I

    .line 1023
    invoke-virtual {v1, v5}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/v7/widget/ViewStubCompat;

    .line 1024
    .local v1, "stub":Landroid/support/v7/widget/ViewStubCompat;
    if-eqz v1, :cond_6

    .line 1026
    invoke-virtual {p0}, Landroid/support/v7/app/x;->m()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroid/support/v7/widget/ViewStubCompat;->setLayoutInflater(Landroid/view/LayoutInflater;)V

    .line 1027
    invoke-virtual {v1}, Landroid/support/v7/widget/ViewStubCompat;->a()Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/support/v7/widget/ActionBarContextView;

    iput-object v5, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    .line 1032
    .end local v1    # "stub":Landroid/support/v7/widget/ViewStubCompat;
    :cond_6
    :goto_2
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    if-eqz v1, :cond_b

    .line 1033
    invoke-virtual {p0}, Landroid/support/v7/app/x;->l()V

    .line 1034
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1}, Landroid/support/v7/widget/ActionBarContextView;->c()V

    .line 1035
    new-instance v1, La/b/d/d/e;

    iget-object v5, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v5}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v5

    iget-object v6, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    iget-object v7, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    if-nez v7, :cond_7

    goto :goto_3

    :cond_7
    const/4 v4, 0x0

    :goto_3
    invoke-direct {v1, v5, v6, p1, v4}, La/b/d/d/e;-><init>(Landroid/content/Context;Landroid/support/v7/widget/ActionBarContextView;La/b/d/d/b$a;Z)V

    move-object v0, v1

    .line 1037
    invoke-virtual {v0}, La/b/d/d/e;->c()Landroid/view/Menu;

    move-result-object v1

    invoke-interface {p1, v0, v1}, La/b/d/d/b$a;->a(La/b/d/d/b;Landroid/view/Menu;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 1038
    invoke-virtual {v0}, La/b/d/d/e;->i()V

    .line 1039
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/ActionBarContextView;->a(La/b/d/d/b;)V

    .line 1040
    iput-object v0, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    .line 1042
    invoke-virtual {p0}, Landroid/support/v7/app/x;->s()Z

    move-result v1

    const/high16 v2, 0x3f800000    # 1.0f

    if-eqz v1, :cond_8

    .line 1043
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 1044
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-static {v1}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v1

    invoke-virtual {v1, v2}, La/b/c/g/A;->a(F)La/b/c/g/A;

    iput-object v1, p0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    .line 1045
    iget-object v1, p0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    new-instance v2, Landroid/support/v7/app/w;

    invoke-direct {v2, p0}, Landroid/support/v7/app/w;-><init>(Landroid/support/v7/app/x;)V

    invoke-virtual {v1, v2}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    goto :goto_4

    .line 1064
    :cond_8
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 1065
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1, v3}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    .line 1066
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->sendAccessibilityEvent(I)V

    .line 1068
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    instance-of v1, v1, Landroid/view/View;

    if-eqz v1, :cond_9

    .line 1069
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    invoke-static {v1}, La/b/c/g/u;->m(Landroid/view/View;)V

    .line 1073
    :cond_9
    :goto_4
    iget-object v1, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    if-eqz v1, :cond_b

    .line 1074
    iget-object v1, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Landroid/support/v7/app/x;->s:Ljava/lang/Runnable;

    invoke-virtual {v1, v2}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    goto :goto_5

    .line 1077
    :cond_a
    iput-object v2, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    .line 1081
    :cond_b
    :goto_5
    iget-object v1, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    if-eqz v1, :cond_c

    iget-object v2, p0, Landroid/support/v7/app/x;->i:Landroid/support/v7/app/n;

    if-eqz v2, :cond_c

    .line 1082
    invoke-interface {v2, v1}, Landroid/support/v7/app/n;->b(La/b/d/d/b;)V

    .line 1084
    :cond_c
    iget-object v1, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    return-object v1
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 299
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 300
    return-void
.end method

.method b(Landroid/support/v7/view/menu/l;)V
    .locals 2
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;

    .line 1643
    iget-boolean v0, p0, Landroid/support/v7/app/x;->G:Z

    if-eqz v0, :cond_0

    .line 1644
    return-void

    .line 1647
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/x;->G:Z

    .line 1648
    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    invoke-interface {v0}, Landroid/support/v7/widget/K;->g()V

    .line 1649
    invoke-virtual {p0}, Landroid/support/v7/app/x;->o()Landroid/view/Window$Callback;

    move-result-object v0

    .line 1650
    .local v0, "cb":Landroid/view/Window$Callback;
    if-eqz v0, :cond_1

    iget-boolean v1, p0, Landroid/support/v7/app/x;->K:Z

    if-nez v1, :cond_1

    .line 1651
    const/16 v1, 0x6c

    invoke-interface {v0, v1, p1}, Landroid/view/Window$Callback;->onPanelClosed(ILandroid/view/Menu;)V

    .line 1653
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v7/app/x;->G:Z

    .line 1654
    return-void
.end method

.method public b(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "lp"    # Landroid/view/ViewGroup$LayoutParams;

    .line 475
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 476
    iget-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 477
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 478
    invoke-virtual {v0, p1, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 479
    iget-object v1, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    invoke-interface {v1}, Landroid/view/Window$Callback;->onContentChanged()V

    .line 480
    return-void
.end method

.method public b(I)Z
    .locals 4
    .param p1, "featureId"    # I

    .line 769
    invoke-direct {p0, p1}, Landroid/support/v7/app/x;->k(I)I

    move-result p1

    .line 771
    iget-boolean v0, p0, Landroid/support/v7/app/x;->F:Z

    const/4 v1, 0x0

    const/16 v2, 0x6c

    if-eqz v0, :cond_0

    if-ne p1, v2, :cond_0

    .line 772
    return v1

    .line 774
    :cond_0
    iget-boolean v0, p0, Landroid/support/v7/app/x;->B:Z

    const/4 v3, 0x1

    if-eqz v0, :cond_1

    if-ne p1, v3, :cond_1

    .line 776
    iput-boolean v1, p0, Landroid/support/v7/app/x;->B:Z

    .line 779
    :cond_1
    if-eq p1, v3, :cond_7

    const/4 v0, 0x2

    if-eq p1, v0, :cond_6

    const/4 v0, 0x5

    if-eq p1, v0, :cond_5

    const/16 v0, 0xa

    if-eq p1, v0, :cond_4

    if-eq p1, v2, :cond_3

    const/16 v0, 0x6d

    if-eq p1, v0, :cond_2

    .line 806
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0, p1}, Landroid/view/Window;->requestFeature(I)Z

    move-result v0

    return v0

    .line 785
    :cond_2
    invoke-direct {p0}, Landroid/support/v7/app/x;->A()V

    .line 786
    iput-boolean v3, p0, Landroid/support/v7/app/x;->C:Z

    .line 787
    return v3

    .line 781
    :cond_3
    invoke-direct {p0}, Landroid/support/v7/app/x;->A()V

    .line 782
    iput-boolean v3, p0, Landroid/support/v7/app/x;->B:Z

    .line 783
    return v3

    .line 789
    :cond_4
    invoke-direct {p0}, Landroid/support/v7/app/x;->A()V

    .line 790
    iput-boolean v3, p0, Landroid/support/v7/app/x;->D:Z

    .line 791
    return v3

    .line 797
    :cond_5
    invoke-direct {p0}, Landroid/support/v7/app/x;->A()V

    .line 798
    iput-boolean v3, p0, Landroid/support/v7/app/x;->A:Z

    .line 799
    return v3

    .line 793
    :cond_6
    invoke-direct {p0}, Landroid/support/v7/app/x;->A()V

    .line 794
    iput-boolean v3, p0, Landroid/support/v7/app/x;->z:Z

    .line 795
    return v3

    .line 801
    :cond_7
    invoke-direct {p0}, Landroid/support/v7/app/x;->A()V

    .line 802
    iput-boolean v3, p0, Landroid/support/v7/app/x;->F:Z

    .line 803
    return v3
.end method

.method b(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "keyCode"    # I
    .param p2, "ev"    # Landroid/view/KeyEvent;

    .line 1128
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 1129
    .local v0, "ab":Landroid/support/v7/app/a;
    const/4 v1, 0x1

    if-eqz v0, :cond_0

    invoke-virtual {v0, p1, p2}, Landroid/support/v7/app/a;->a(ILandroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1130
    return v1

    .line 1135
    :cond_0
    iget-object v2, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    if-eqz v2, :cond_2

    .line 1136
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    invoke-direct {p0, v2, v3, p2, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;ILandroid/view/KeyEvent;I)Z

    move-result v2

    .line 1138
    .local v2, "handled":Z
    if-eqz v2, :cond_2

    .line 1139
    iget-object v3, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    if-eqz v3, :cond_1

    .line 1140
    iput-boolean v1, v3, Landroid/support/v7/app/x$f;->n:Z

    .line 1142
    :cond_1
    return v1

    .line 1150
    .end local v2    # "handled":Z
    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/x;->I:Landroid/support/v7/app/x$f;

    const/4 v3, 0x0

    if-nez v2, :cond_3

    .line 1151
    invoke-virtual {p0, v3, v1}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v2

    .line 1152
    .local v2, "st":Landroid/support/v7/app/x$f;
    invoke-direct {p0, v2, p2}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    .line 1153
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v4

    invoke-direct {p0, v2, v4, p2, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;ILandroid/view/KeyEvent;I)Z

    move-result v4

    .line 1154
    .local v4, "handled":Z
    iput-boolean v3, v2, Landroid/support/v7/app/x$f;->m:Z

    .line 1155
    if-eqz v4, :cond_3

    .line 1156
    return v1

    .line 1159
    .end local v2    # "st":Landroid/support/v7/app/x$f;
    .end local v4    # "handled":Z
    :cond_3
    return v3
.end method

.method public c()Landroid/view/MenuInflater;
    .locals 2

    .line 391
    iget-object v0, p0, Landroid/support/v7/app/x;->k:Landroid/view/MenuInflater;

    if-nez v0, :cond_1

    .line 392
    invoke-direct {p0}, Landroid/support/v7/app/x;->y()V

    .line 393
    new-instance v0, La/b/d/d/g;

    iget-object v1, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    if-eqz v1, :cond_0

    .line 394
    invoke-virtual {v1}, Landroid/support/v7/app/a;->h()Landroid/content/Context;

    move-result-object v1

    goto :goto_0

    :cond_0
    iget-object v1, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    :goto_0
    invoke-direct {v0, v1}, La/b/d/d/g;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/support/v7/app/x;->k:Landroid/view/MenuInflater;

    .line 396
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x;->k:Landroid/view/MenuInflater;

    return-object v0
.end method

.method public c(I)V
    .locals 2
    .param p1, "resId"    # I

    .line 466
    invoke-direct {p0}, Landroid/support/v7/app/x;->w()V

    .line 467
    iget-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    const v1, 0x1020002

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 468
    .local v0, "contentParent":Landroid/view/ViewGroup;
    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 469
    iget-object v1, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    invoke-virtual {v1, p1, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 470
    iget-object v1, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    invoke-interface {v1}, Landroid/view/Window$Callback;->onContentChanged()V

    .line 471
    return-void
.end method

.method public c(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .line 492
    iget v0, p0, Landroid/support/v7/app/x;->L:I

    const/16 v1, -0x64

    if-eq v0, v1, :cond_0

    .line 494
    const-string v1, "appcompat:local_night_mode"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 496
    :cond_0
    return-void
.end method

.method c(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1188
    const/4 v0, 0x4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-eq p1, v0, :cond_1

    const/16 v0, 0x52

    if-eq p1, v0, :cond_0

    goto :goto_0

    .line 1190
    :cond_0
    invoke-direct {p0, v2, p2}, Landroid/support/v7/app/x;->e(ILandroid/view/KeyEvent;)Z

    .line 1191
    return v1

    .line 1193
    :cond_1
    iget-boolean v0, p0, Landroid/support/v7/app/x;->J:Z

    .line 1194
    .local v0, "wasLongPressBackDown":Z
    iput-boolean v2, p0, Landroid/support/v7/app/x;->J:Z

    .line 1196
    invoke-virtual {p0, v2, v2}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v3

    .line 1197
    .local v3, "st":Landroid/support/v7/app/x$f;
    if-eqz v3, :cond_3

    iget-boolean v4, v3, Landroid/support/v7/app/x$f;->o:Z

    if-eqz v4, :cond_3

    .line 1198
    if-nez v0, :cond_2

    .line 1202
    invoke-virtual {p0, v3, v1}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1204
    :cond_2
    return v1

    .line 1206
    :cond_3
    invoke-virtual {p0}, Landroid/support/v7/app/x;->q()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1207
    return v1

    .line 1211
    .end local v0    # "wasLongPressBackDown":Z
    .end local v3    # "st":Landroid/support/v7/app/x$f;
    :cond_4
    :goto_0
    return v2
.end method

.method public d()Landroid/support/v7/app/a;
    .locals 1

    .line 306
    invoke-direct {p0}, Landroid/support/v7/app/x;->y()V

    .line 307
    iget-object v0, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    return-object v0
.end method

.method d(I)V
    .locals 2
    .param p1, "featureId"    # I

    .line 1657
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    invoke-virtual {p0, v1, v0}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    .line 1658
    return-void
.end method

.method public e()V
    .locals 3

    .line 1300
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 1301
    .local v0, "layoutInflater":Landroid/view/LayoutInflater;
    invoke-virtual {v0}, Landroid/view/LayoutInflater;->getFactory()Landroid/view/LayoutInflater$Factory;

    move-result-object v1

    if-nez v1, :cond_0

    .line 1302
    invoke-static {v0, p0}, La/b/c/g/h;->a(Landroid/view/LayoutInflater;Landroid/view/LayoutInflater$Factory2;)V

    goto :goto_0

    .line 1304
    :cond_0
    invoke-virtual {v0}, Landroid/view/LayoutInflater;->getFactory2()Landroid/view/LayoutInflater$Factory2;

    move-result-object v1

    instance-of v1, v1, Landroid/support/v7/app/x;

    if-nez v1, :cond_1

    .line 1305
    const-string v1, "AppCompatDelegate"

    const-string v2, "The Activity\'s LayoutInflater already has a Factory installed so we can not install AppCompat\'s"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1309
    :cond_1
    :goto_0
    return-void
.end method

.method e(I)V
    .locals 4
    .param p1, "featureId"    # I

    .line 1848
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 1849
    .local v1, "st":Landroid/support/v7/app/x$f;
    const/4 v2, 0x0

    .line 1850
    .local v2, "savedActionViewStates":Landroid/os/Bundle;
    iget-object v3, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-eqz v3, :cond_1

    .line 1851
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    move-object v2, v3

    .line 1852
    iget-object v3, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v3, v2}, Landroid/support/v7/view/menu/l;->b(Landroid/os/Bundle;)V

    .line 1853
    invoke-virtual {v2}, Landroid/os/Bundle;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 1854
    iput-object v2, v1, Landroid/support/v7/app/x$f;->s:Landroid/os/Bundle;

    .line 1857
    :cond_0
    iget-object v3, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v3}, Landroid/support/v7/view/menu/l;->s()V

    .line 1858
    iget-object v3, v1, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    invoke-virtual {v3}, Landroid/support/v7/view/menu/l;->clear()V

    .line 1860
    :cond_1
    iput-boolean v0, v1, Landroid/support/v7/app/x$f;->r:Z

    .line 1861
    iput-boolean v0, v1, Landroid/support/v7/app/x$f;->q:Z

    .line 1864
    const/16 v0, 0x6c

    if-eq p1, v0, :cond_2

    if-nez p1, :cond_3

    :cond_2
    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v0, :cond_3

    .line 1866
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 1867
    if-eqz v1, :cond_3

    .line 1868
    iput-boolean v0, v1, Landroid/support/v7/app/x$f;->m:Z

    .line 1869
    const/4 v0, 0x0

    invoke-direct {p0, v1, v0}, Landroid/support/v7/app/x;->b(Landroid/support/v7/app/x$f;Landroid/view/KeyEvent;)Z

    .line 1872
    :cond_3
    return-void
.end method

.method f(I)I
    .locals 3
    .param p1, "mode"    # I

    .line 2044
    const/16 v0, -0x64

    const/4 v1, -0x1

    if-eq p1, v0, :cond_2

    if-eqz p1, :cond_0

    .line 2060
    return p1

    .line 2046
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x17

    if-lt v0, v2, :cond_1

    .line 2047
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    const-class v2, Landroid/app/UiModeManager;

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/UiModeManager;

    .line 2048
    .local v0, "uiModeManager":Landroid/app/UiModeManager;
    invoke-virtual {v0}, Landroid/app/UiModeManager;->getNightMode()I

    move-result v2

    if-nez v2, :cond_1

    .line 2051
    return v1

    .line 2054
    .end local v0    # "uiModeManager":Landroid/app/UiModeManager;
    :cond_1
    invoke-direct {p0}, Landroid/support/v7/app/x;->v()V

    .line 2055
    iget-object v0, p0, Landroid/support/v7/app/x;->N:Landroid/support/v7/app/x$d;

    invoke-virtual {v0}, Landroid/support/v7/app/x$d;->c()I

    move-result v0

    return v0

    .line 2058
    :cond_2
    return v1
.end method

.method public f()V
    .locals 2

    .line 929
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 930
    .local v0, "ab":Landroid/support/v7/app/a;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/app/a;->i()Z

    move-result v1

    if-eqz v1, :cond_0

    return-void

    .line 932
    :cond_0
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Landroid/support/v7/app/x;->j(I)V

    .line 933
    return-void
.end method

.method public g()V
    .locals 2

    .line 500
    iget-boolean v0, p0, Landroid/support/v7/app/x;->O:Z

    if-eqz v0, :cond_0

    .line 501
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/app/x;->Q:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 504
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/x;->K:Z

    .line 506
    iget-object v0, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    if-eqz v0, :cond_1

    .line 507
    invoke-virtual {v0}, Landroid/support/v7/app/a;->j()V

    .line 511
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x;->N:Landroid/support/v7/app/x$d;

    if-eqz v0, :cond_2

    .line 512
    invoke-virtual {v0}, Landroid/support/v7/app/x$d;->a()V

    .line 514
    :cond_2
    return-void
.end method

.method g(I)V
    .locals 2
    .param p1, "featureId"    # I

    .line 874
    const/16 v0, 0x6c

    if-ne p1, v0, :cond_0

    .line 875
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 876
    .local v0, "ab":Landroid/support/v7/app/a;
    if-eqz v0, :cond_0

    .line 877
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/a;->b(Z)V

    .line 880
    .end local v0    # "ab":Landroid/support/v7/app/a;
    :cond_0
    return-void
.end method

.method public h()V
    .locals 2

    .line 449
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 450
    .local v0, "ab":Landroid/support/v7/app/a;
    if-eqz v0, :cond_0

    .line 451
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/a;->d(Z)V

    .line 453
    :cond_0
    return-void
.end method

.method h(I)V
    .locals 3
    .param p1, "featureId"    # I

    .line 858
    const/4 v0, 0x0

    const/16 v1, 0x6c

    if-ne p1, v1, :cond_0

    .line 859
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v1

    .line 860
    .local v1, "ab":Landroid/support/v7/app/a;
    if-eqz v1, :cond_1

    .line 861
    invoke-virtual {v1, v0}, Landroid/support/v7/app/a;->b(Z)V

    goto :goto_0

    .line 863
    .end local v1    # "ab":Landroid/support/v7/app/a;
    :cond_0
    if-nez p1, :cond_1

    .line 866
    const/4 v1, 0x1

    invoke-virtual {p0, p1, v1}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v1

    .line 867
    .local v1, "st":Landroid/support/v7/app/x$f;
    iget-boolean v2, v1, Landroid/support/v7/app/x$f;->o:Z

    if-eqz v2, :cond_2

    .line 868
    invoke-virtual {p0, v1, v0}, Landroid/support/v7/app/x;->a(Landroid/support/v7/app/x$f;Z)V

    goto :goto_1

    .line 863
    .end local v1    # "st":Landroid/support/v7/app/x$f;
    :cond_1
    :goto_0
    nop

    .line 871
    :cond_2
    :goto_1
    return-void
.end method

.method i(I)I
    .locals 11
    .param p1, "insetTop"    # I

    .line 1881
    const/4 v0, 0x0

    .line 1883
    .local v0, "showStatusGuard":Z
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    const/4 v2, 0x0

    if-eqz v1, :cond_8

    .line 1884
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    instance-of v1, v1, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v1, :cond_8

    .line 1885
    iget-object v1, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    .line 1886
    invoke-virtual {v1}, Landroid/view/ViewGroup;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 1887
    .local v1, "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    const/4 v3, 0x0

    .line 1889
    .local v3, "mlpChanged":Z
    iget-object v4, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->isShown()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 1890
    iget-object v4, p0, Landroid/support/v7/app/x;->S:Landroid/graphics/Rect;

    if-nez v4, :cond_0

    .line 1891
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    iput-object v4, p0, Landroid/support/v7/app/x;->S:Landroid/graphics/Rect;

    .line 1892
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    iput-object v4, p0, Landroid/support/v7/app/x;->T:Landroid/graphics/Rect;

    .line 1894
    :cond_0
    iget-object v4, p0, Landroid/support/v7/app/x;->S:Landroid/graphics/Rect;

    .line 1895
    .local v4, "insets":Landroid/graphics/Rect;
    iget-object v5, p0, Landroid/support/v7/app/x;->T:Landroid/graphics/Rect;

    .line 1896
    .local v5, "localInsets":Landroid/graphics/Rect;
    invoke-virtual {v4, v2, p1, v2, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 1898
    iget-object v6, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    invoke-static {v6, v4, v5}, Landroid/support/v7/widget/Ha;->a(Landroid/view/View;Landroid/graphics/Rect;Landroid/graphics/Rect;)V

    .line 1899
    iget v6, v5, Landroid/graphics/Rect;->top:I

    if-nez v6, :cond_1

    move v6, p1

    goto :goto_0

    :cond_1
    const/4 v6, 0x0

    .line 1900
    .local v6, "newMargin":I
    :goto_0
    iget v7, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    if-eq v7, v6, :cond_3

    .line 1901
    const/4 v3, 0x1

    .line 1902
    iput p1, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 1904
    iget-object v7, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    if-nez v7, :cond_2

    .line 1905
    new-instance v7, Landroid/view/View;

    iget-object v8, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-direct {v7, v8}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v7, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    .line 1906
    iget-object v7, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    iget-object v8, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, La/b/d/a/c;->abc_input_method_navigation_guard:I

    .line 1907
    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    .line 1906
    invoke-virtual {v7, v8}, Landroid/view/View;->setBackgroundColor(I)V

    .line 1908
    iget-object v7, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    iget-object v8, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    new-instance v9, Landroid/view/ViewGroup$LayoutParams;

    const/4 v10, -0x1

    invoke-direct {v9, v10, p1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v7, v8, v10, v9}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    goto :goto_1

    .line 1912
    :cond_2
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    .line 1913
    .local v7, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget v8, v7, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-eq v8, p1, :cond_3

    .line 1914
    iput p1, v7, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 1915
    iget-object v8, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    invoke-virtual {v8, v7}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1922
    .end local v7    # "lp":Landroid/view/ViewGroup$LayoutParams;
    :cond_3
    :goto_1
    iget-object v7, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    if-eqz v7, :cond_4

    const/4 v7, 0x1

    goto :goto_2

    :cond_4
    const/4 v7, 0x0

    :goto_2
    move v0, v7

    .line 1928
    iget-boolean v7, p0, Landroid/support/v7/app/x;->D:Z

    if-nez v7, :cond_5

    if-eqz v0, :cond_5

    .line 1929
    const/4 p1, 0x0

    .line 1931
    .end local v4    # "insets":Landroid/graphics/Rect;
    .end local v5    # "localInsets":Landroid/graphics/Rect;
    .end local v6    # "newMargin":I
    :cond_5
    goto :goto_3

    .line 1933
    :cond_6
    iget v4, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    if-eqz v4, :cond_7

    .line 1934
    const/4 v3, 0x1

    .line 1935
    iput v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 1938
    :cond_7
    :goto_3
    if-eqz v3, :cond_8

    .line 1939
    iget-object v4, p0, Landroid/support/v7/app/x;->q:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v4, v1}, Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1943
    .end local v1    # "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    .end local v3    # "mlpChanged":Z
    :cond_8
    iget-object v1, p0, Landroid/support/v7/app/x;->y:Landroid/view/View;

    if-eqz v1, :cond_a

    .line 1944
    if-eqz v0, :cond_9

    goto :goto_4

    :cond_9
    const/16 v2, 0x8

    :goto_4
    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1947
    :cond_a
    return p1
.end method

.method public i()V
    .locals 0

    .line 431
    invoke-virtual {p0}, Landroid/support/v7/app/x;->a()Z

    .line 432
    return-void
.end method

.method public j()V
    .locals 2

    .line 436
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 437
    .local v0, "ab":Landroid/support/v7/app/a;
    if-eqz v0, :cond_0

    .line 438
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/app/a;->d(Z)V

    .line 442
    :cond_0
    iget-object v1, p0, Landroid/support/v7/app/x;->N:Landroid/support/v7/app/x$d;

    if-eqz v1, :cond_1

    .line 443
    invoke-virtual {v1}, Landroid/support/v7/app/x$d;->a()V

    .line 445
    :cond_1
    return-void
.end method

.method k()V
    .locals 2

    .line 1976
    iget-object v0, p0, Landroid/support/v7/app/x;->m:Landroid/support/v7/widget/K;

    if-eqz v0, :cond_0

    .line 1977
    invoke-interface {v0}, Landroid/support/v7/widget/K;->g()V

    .line 1980
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_2

    .line 1981
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/app/x;->s:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 1982
    iget-object v0, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1984
    :try_start_0
    iget-object v0, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1988
    goto :goto_0

    .line 1985
    :catch_0
    move-exception v0

    .line 1990
    :cond_1
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/app/x;->r:Landroid/widget/PopupWindow;

    .line 1992
    :cond_2
    invoke-virtual {p0}, Landroid/support/v7/app/x;->l()V

    .line 1994
    const/4 v0, 0x0

    invoke-virtual {p0, v0, v0}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v0

    .line 1995
    .local v0, "st":Landroid/support/v7/app/x$f;
    if-eqz v0, :cond_3

    iget-object v1, v0, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-eqz v1, :cond_3

    .line 1996
    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->close()V

    .line 1998
    :cond_3
    return-void
.end method

.method l()V
    .locals 1

    .line 1104
    iget-object v0, p0, Landroid/support/v7/app/x;->t:La/b/c/g/A;

    if-eqz v0, :cond_0

    .line 1105
    invoke-virtual {v0}, La/b/c/g/A;->a()V

    .line 1107
    :cond_0
    return-void
.end method

.method final m()Landroid/content/Context;
    .locals 2

    .line 374
    const/4 v0, 0x0

    .line 377
    .local v0, "context":Landroid/content/Context;
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v1

    .line 378
    .local v1, "ab":Landroid/support/v7/app/a;
    if-eqz v1, :cond_0

    .line 379
    invoke-virtual {v1}, Landroid/support/v7/app/a;->h()Landroid/content/Context;

    move-result-object v0

    .line 382
    :cond_0
    if-nez v0, :cond_1

    .line 383
    iget-object v0, p0, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    .line 385
    :cond_1
    return-object v0
.end method

.method final n()Ljava/lang/CharSequence;
    .locals 2

    .line 850
    iget-object v0, p0, Landroid/support/v7/app/x;->g:Landroid/view/Window$Callback;

    instance-of v1, v0, Landroid/app/Activity;

    if-eqz v1, :cond_0

    .line 851
    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0

    .line 854
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x;->l:Ljava/lang/CharSequence;

    return-object v0
.end method

.method final o()Landroid/view/Window$Callback;
    .locals 1

    .line 315
    iget-object v0, p0, Landroid/support/v7/app/x;->f:Landroid/view/Window;

    invoke-virtual {v0}, Landroid/view/Window;->getCallback()Landroid/view/Window$Callback;

    move-result-object v0

    return-object v0
.end method

.method public final onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "attrs"    # Landroid/util/AttributeSet;

    .line 1316
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/support/v7/app/x;->a(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .line 1324
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/support/v7/app/x;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public p()Z
    .locals 1

    .line 1100
    iget-boolean v0, p0, Landroid/support/v7/app/x;->u:Z

    return v0
.end method

.method q()Z
    .locals 3

    .line 1111
    iget-object v0, p0, Landroid/support/v7/app/x;->p:La/b/d/d/b;

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 1112
    invoke-virtual {v0}, La/b/d/d/b;->a()V

    .line 1113
    return v1

    .line 1117
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/x;->d()Landroid/support/v7/app/a;

    move-result-object v0

    .line 1118
    .local v0, "ab":Landroid/support/v7/app/a;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/support/v7/app/a;->f()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1119
    return v1

    .line 1123
    :cond_1
    const/4 v1, 0x0

    return v1
.end method

.method final r()Landroid/support/v7/app/a;
    .locals 1

    .line 311
    iget-object v0, p0, Landroid/support/v7/app/x;->j:Landroid/support/v7/app/a;

    return-object v0
.end method

.method final s()Z
    .locals 1

    .line 1090
    iget-boolean v0, p0, Landroid/support/v7/app/x;->v:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/x;->w:Landroid/view/ViewGroup;

    if-eqz v0, :cond_0

    invoke-static {v0}, La/b/c/g/u;->k(Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
