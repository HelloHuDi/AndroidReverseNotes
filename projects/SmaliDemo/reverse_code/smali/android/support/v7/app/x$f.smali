.class public final Landroid/support/v7/app/x$f;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1c
    name = "f"
.end annotation


# instance fields
.field a:I

.field b:I

.field c:I

.field d:I

.field e:I

.field f:I

.field g:Landroid/view/ViewGroup;

.field h:Landroid/view/View;

.field i:Landroid/view/View;

.field j:Landroid/support/v7/view/menu/l;

.field k:Landroid/support/v7/view/menu/j;

.field l:Landroid/content/Context;

.field m:Z

.field n:Z

.field o:Z

.field public p:Z

.field q:Z

.field r:Z

.field s:Landroid/os/Bundle;


# direct methods
.method constructor <init>(I)V
    .locals 1
    .param p1, "featureId"    # I

    .line 2323
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2324
    iput p1, p0, Landroid/support/v7/app/x$f;->a:I

    .line 2326
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/app/x$f;->q:Z

    .line 2327
    return-void
.end method


# virtual methods
.method a(Landroid/support/v7/view/menu/v$a;)Landroid/support/v7/view/menu/w;
    .locals 3
    .param p1, "cb"    # Landroid/support/v7/view/menu/v$a;

    .line 2391
    iget-object v0, p0, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    return-object v0

    .line 2393
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    if-nez v0, :cond_1

    .line 2394
    new-instance v0, Landroid/support/v7/view/menu/j;

    iget-object v1, p0, Landroid/support/v7/app/x$f;->l:Landroid/content/Context;

    sget v2, La/b/d/a/g;->abc_list_menu_item_layout:I

    invoke-direct {v0, v1, v2}, Landroid/support/v7/view/menu/j;-><init>(Landroid/content/Context;I)V

    iput-object v0, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    .line 2396
    iget-object v0, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    invoke-virtual {v0, p1}, Landroid/support/v7/view/menu/j;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 2397
    iget-object v0, p0, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    iget-object v1, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/v;)V

    .line 2400
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    iget-object v1, p0, Landroid/support/v7/app/x$f;->g:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/j;->a(Landroid/view/ViewGroup;)Landroid/support/v7/view/menu/w;

    move-result-object v0

    .line 2402
    .local v0, "result":Landroid/support/v7/view/menu/w;
    return-object v0
.end method

.method a(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .line 2347
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 2348
    .local v0, "outValue":Landroid/util/TypedValue;
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->newTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    .line 2349
    .local v1, "widgetTheme":Landroid/content/res/Resources$Theme;
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 2352
    sget v2, La/b/d/a/a;->actionBarPopupTheme:I

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 2353
    iget v2, v0, Landroid/util/TypedValue;->resourceId:I

    if-eqz v2, :cond_0

    .line 2354
    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 2358
    :cond_0
    sget v2, La/b/d/a/a;->panelMenuListTheme:I

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 2359
    iget v2, v0, Landroid/util/TypedValue;->resourceId:I

    if-eqz v2, :cond_1

    .line 2360
    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    goto :goto_0

    .line 2362
    :cond_1
    sget v2, La/b/d/a/i;->Theme_AppCompat_CompactMenu:I

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources$Theme;->applyStyle(IZ)V

    .line 2365
    :goto_0
    new-instance v2, La/b/d/d/d;

    const/4 v3, 0x0

    invoke-direct {v2, p1, v3}, La/b/d/d/d;-><init>(Landroid/content/Context;I)V

    move-object p1, v2

    .line 2366
    invoke-virtual {p1}, La/b/d/d/d;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/res/Resources$Theme;->setTo(Landroid/content/res/Resources$Theme;)V

    .line 2368
    iput-object p1, p0, Landroid/support/v7/app/x$f;->l:Landroid/content/Context;

    .line 2370
    sget-object v2, La/b/d/a/j;->AppCompatTheme:[I

    invoke-virtual {p1, v2}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 2371
    .local v2, "a":Landroid/content/res/TypedArray;
    sget v4, La/b/d/a/j;->AppCompatTheme_panelBackground:I

    invoke-virtual {v2, v4, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v4

    iput v4, p0, Landroid/support/v7/app/x$f;->b:I

    .line 2373
    sget v4, La/b/d/a/j;->AppCompatTheme_android_windowAnimationStyle:I

    invoke-virtual {v2, v4, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, p0, Landroid/support/v7/app/x$f;->f:I

    .line 2375
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 2376
    return-void
.end method

.method a(Landroid/support/v7/view/menu/l;)V
    .locals 2
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;

    .line 2379
    iget-object v0, p0, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-ne p1, v0, :cond_0

    return-void

    .line 2381
    :cond_0
    if-eqz v0, :cond_1

    .line 2382
    iget-object v1, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->b(Landroid/support/v7/view/menu/v;)V

    .line 2384
    :cond_1
    iput-object p1, p0, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    .line 2385
    if-eqz p1, :cond_2

    .line 2386
    iget-object v0, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    if-eqz v0, :cond_2

    invoke-virtual {p1, v0}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/v;)V

    .line 2388
    :cond_2
    return-void
.end method

.method public a()Z
    .locals 3

    .line 2330
    iget-object v0, p0, Landroid/support/v7/app/x$f;->h:Landroid/view/View;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    .line 2331
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x$f;->i:Landroid/view/View;

    const/4 v2, 0x1

    if-eqz v0, :cond_1

    return v2

    .line 2333
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/x$f;->k:Landroid/support/v7/view/menu/j;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/j;->b()Landroid/widget/ListAdapter;

    move-result-object v0

    invoke-interface {v0}, Landroid/widget/ListAdapter;->getCount()I

    move-result v0

    if-lez v0, :cond_2

    const/4 v1, 0x1

    :cond_2
    return v1
.end method
