.class Landroid/support/v7/widget/Toolbar$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/view/menu/v;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/Toolbar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "a"
.end annotation


# instance fields
.field a:Landroid/support/v7/view/menu/l;

.field b:Landroid/support/v7/view/menu/p;

.field final synthetic c:Landroid/support/v7/widget/Toolbar;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/Toolbar;)V
    .locals 0

    .line 2309
    iput-object p1, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2310
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;Landroid/support/v7/view/menu/l;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "menu"    # Landroid/support/v7/view/menu/l;

    .line 2315
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->a:Landroid/support/v7/view/menu/l;

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->b:Landroid/support/v7/view/menu/p;

    if-eqz v1, :cond_0

    .line 2316
    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/p;)Z

    .line 2318
    :cond_0
    iput-object p2, p0, Landroid/support/v7/widget/Toolbar$a;->a:Landroid/support/v7/view/menu/l;

    .line 2319
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 0
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 2361
    return-void
.end method

.method public a(Z)V
    .locals 5
    .param p1, "cleared"    # Z

    .line 2329
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->b:Landroid/support/v7/view/menu/p;

    if-eqz v0, :cond_2

    .line 2330
    const/4 v0, 0x0

    .line 2332
    .local v0, "found":Z
    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->a:Landroid/support/v7/view/menu/l;

    if-eqz v1, :cond_1

    .line 2333
    invoke-virtual {v1}, Landroid/support/v7/view/menu/l;->size()I

    move-result v1

    .line 2334
    .local v1, "count":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 2335
    iget-object v3, p0, Landroid/support/v7/widget/Toolbar$a;->a:Landroid/support/v7/view/menu/l;

    invoke-virtual {v3, v2}, Landroid/support/v7/view/menu/l;->getItem(I)Landroid/view/MenuItem;

    move-result-object v3

    .line 2336
    .local v3, "item":Landroid/view/MenuItem;
    iget-object v4, p0, Landroid/support/v7/widget/Toolbar$a;->b:Landroid/support/v7/view/menu/p;

    if-ne v3, v4, :cond_0

    .line 2337
    const/4 v0, 0x1

    .line 2338
    goto :goto_1

    .line 2334
    .end local v3    # "item":Landroid/view/MenuItem;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 2343
    .end local v1    # "count":I
    .end local v2    # "i":I
    :cond_1
    :goto_1
    if-nez v0, :cond_2

    .line 2345
    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->a:Landroid/support/v7/view/menu/l;

    iget-object v2, p0, Landroid/support/v7/widget/Toolbar$a;->b:Landroid/support/v7/view/menu/p;

    invoke-virtual {p0, v1, v2}, Landroid/support/v7/widget/Toolbar$a;->b(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z

    .line 2348
    .end local v0    # "found":Z
    :cond_2
    return-void
.end method

.method public a()Z
    .locals 1

    .line 2365
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/support/v7/view/menu/D;)Z
    .locals 1
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/D;

    .line 2356
    const/4 v0, 0x0

    return v0
.end method

.method public a(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z
    .locals 6
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 2370
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->e()V

    .line 2371
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v0, v0, Landroid/support/v7/widget/Toolbar;->h:Landroid/widget/ImageButton;

    invoke-virtual {v0}, Landroid/widget/ImageButton;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 2372
    .local v0, "collapseButtonParent":Landroid/view/ViewParent;
    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    if-eq v0, v1, :cond_1

    .line 2373
    instance-of v2, v0, Landroid/view/ViewGroup;

    if-eqz v2, :cond_0

    .line 2374
    move-object v2, v0

    check-cast v2, Landroid/view/ViewGroup;

    iget-object v1, v1, Landroid/support/v7/widget/Toolbar;->h:Landroid/widget/ImageButton;

    invoke-virtual {v2, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 2376
    :cond_0
    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v2, v1, Landroid/support/v7/widget/Toolbar;->h:Landroid/widget/ImageButton;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 2378
    :cond_1
    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {p2}, Landroid/support/v7/view/menu/p;->getActionView()Landroid/view/View;

    move-result-object v2

    iput-object v2, v1, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    .line 2379
    iput-object p2, p0, Landroid/support/v7/widget/Toolbar$a;->b:Landroid/support/v7/view/menu/p;

    .line 2380
    iget-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v1, v1, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    .line 2381
    .local v1, "expandedActionParent":Landroid/view/ViewParent;
    iget-object v2, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    if-eq v1, v2, :cond_3

    .line 2382
    instance-of v3, v1, Landroid/view/ViewGroup;

    if-eqz v3, :cond_2

    .line 2383
    move-object v3, v1

    check-cast v3, Landroid/view/ViewGroup;

    iget-object v2, v2, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    invoke-virtual {v3, v2}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 2385
    :cond_2
    iget-object v2, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v2}, Landroid/support/v7/widget/Toolbar;->generateDefaultLayoutParams()Landroid/support/v7/widget/Toolbar$b;

    move-result-object v2

    .line 2386
    .local v2, "lp":Landroid/support/v7/widget/Toolbar$b;
    const v3, 0x800003

    iget-object v4, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget v5, v4, Landroid/support/v7/widget/Toolbar;->n:I

    and-int/lit8 v5, v5, 0x70

    or-int/2addr v3, v5

    iput v3, v2, Landroid/support/v7/app/a$a;->a:I

    .line 2387
    const/4 v3, 0x2

    iput v3, v2, Landroid/support/v7/widget/Toolbar$b;->b:I

    .line 2388
    iget-object v3, v4, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    invoke-virtual {v3, v2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2389
    iget-object v3, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v4, v3, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 2392
    .end local v2    # "lp":Landroid/support/v7/widget/Toolbar$b;
    :cond_3
    iget-object v2, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v2}, Landroid/support/v7/widget/Toolbar;->j()V

    .line 2393
    iget-object v2, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v2}, Landroid/view/ViewGroup;->requestLayout()V

    .line 2394
    const/4 v2, 0x1

    invoke-virtual {p2, v2}, Landroid/support/v7/view/menu/p;->a(Z)V

    .line 2396
    iget-object v3, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v3, v3, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    instance-of v4, v3, La/b/d/d/c;

    if-eqz v4, :cond_4

    .line 2397
    check-cast v3, La/b/d/d/c;

    invoke-interface {v3}, La/b/d/d/c;->onActionViewExpanded()V

    .line 2400
    :cond_4
    return v2
.end method

.method public b(Landroid/support/v7/view/menu/l;Landroid/support/v7/view/menu/p;)Z
    .locals 2
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/support/v7/view/menu/p;

    .line 2407
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v0, v0, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    instance-of v1, v0, La/b/d/d/c;

    if-eqz v1, :cond_0

    .line 2408
    check-cast v0, La/b/d/d/c;

    invoke-interface {v0}, La/b/d/d/c;->onActionViewCollapsed()V

    .line 2411
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v1, v0, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 2412
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    iget-object v1, v0, Landroid/support/v7/widget/Toolbar;->h:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 2413
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/support/v7/widget/Toolbar;->i:Landroid/view/View;

    .line 2415
    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->a()V

    .line 2416
    iput-object v1, p0, Landroid/support/v7/widget/Toolbar$a;->b:Landroid/support/v7/view/menu/p;

    .line 2417
    iget-object v0, p0, Landroid/support/v7/widget/Toolbar$a;->c:Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->requestLayout()V

    .line 2418
    const/4 v0, 0x0

    invoke-virtual {p2, v0}, Landroid/support/v7/view/menu/p;->a(Z)V

    .line 2420
    const/4 v0, 0x1

    return v0
.end method
