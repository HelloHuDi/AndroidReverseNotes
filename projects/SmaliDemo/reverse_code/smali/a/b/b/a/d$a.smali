.class La/b/b/a/d$a;
.super Landroid/graphics/drawable/Drawable$ConstantState;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field a:I

.field b:La/b/b/a/k;

.field c:Landroid/animation/AnimatorSet;

.field d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/animation/Animator;",
            ">;"
        }
    .end annotation
.end field

.field e:La/b/c/f/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/b<",
            "Landroid/animation/Animator;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;La/b/b/a/d$a;Landroid/graphics/drawable/Drawable$Callback;Landroid/content/res/Resources;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "copy"    # La/b/b/a/d$a;
    .param p3, "owner"    # Landroid/graphics/drawable/Drawable$Callback;
    .param p4, "res"    # Landroid/content/res/Resources;

    .line 589
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable$ConstantState;-><init>()V

    .line 590
    if-eqz p2, :cond_3

    .line 591
    iget v0, p2, La/b/b/a/d$a;->a:I

    iput v0, p0, La/b/b/a/d$a;->a:I

    .line 592
    iget-object v0, p2, La/b/b/a/d$a;->b:La/b/b/a/k;

    if-eqz v0, :cond_1

    .line 593
    invoke-virtual {v0}, La/b/b/a/k;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v0

    .line 594
    .local v0, "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    if-eqz p4, :cond_0

    .line 595
    invoke-virtual {v0, p4}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, La/b/b/a/k;

    iput-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    goto :goto_0

    .line 597
    :cond_0
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, La/b/b/a/k;

    iput-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    .line 599
    :goto_0
    iget-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v1}, La/b/b/a/k;->mutate()Landroid/graphics/drawable/Drawable;

    check-cast v1, La/b/b/a/k;

    iput-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    .line 600
    iget-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v1, p3}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 601
    iget-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    iget-object v2, p2, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 602
    iget-object v1, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, La/b/b/a/k;->a(Z)V

    .line 604
    .end local v0    # "cs":Landroid/graphics/drawable/Drawable$ConstantState;
    :cond_1
    iget-object v0, p2, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    .line 605
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 606
    .local v0, "numAnimators":I
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v1, p0, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    .line 607
    new-instance v1, La/b/c/f/b;

    invoke-direct {v1, v0}, La/b/c/f/b;-><init>(I)V

    iput-object v1, p0, La/b/b/a/d$a;->e:La/b/c/f/b;

    .line 608
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v0, :cond_2

    .line 609
    iget-object v2, p2, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/Animator;

    .line 610
    .local v2, "anim":Landroid/animation/Animator;
    invoke-virtual {v2}, Landroid/animation/Animator;->clone()Landroid/animation/Animator;

    move-result-object v3

    .line 611
    .local v3, "animClone":Landroid/animation/Animator;
    iget-object v4, p2, La/b/b/a/d$a;->e:La/b/c/f/b;

    invoke-virtual {v4, v2}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 612
    .local v4, "targetName":Ljava/lang/String;
    iget-object v5, p0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v5, v4}, La/b/b/a/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    .line 613
    .local v5, "targetObject":Ljava/lang/Object;
    invoke-virtual {v3, v5}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    .line 614
    iget-object v6, p0, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    invoke-virtual {v6, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 615
    iget-object v6, p0, La/b/b/a/d$a;->e:La/b/c/f/b;

    invoke-virtual {v6, v3, v4}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 608
    .end local v2    # "anim":Landroid/animation/Animator;
    .end local v3    # "animClone":Landroid/animation/Animator;
    .end local v4    # "targetName":Ljava/lang/String;
    .end local v5    # "targetObject":Ljava/lang/Object;
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 617
    .end local v1    # "i":I
    :cond_2
    invoke-virtual {p0}, La/b/b/a/d$a;->a()V

    .line 620
    .end local v0    # "numAnimators":I
    :cond_3
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .line 638
    iget-object v0, p0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    if-nez v0, :cond_0

    .line 639
    new-instance v0, Landroid/animation/AnimatorSet;

    invoke-direct {v0}, Landroid/animation/AnimatorSet;-><init>()V

    iput-object v0, p0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    .line 641
    :cond_0
    iget-object v0, p0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    iget-object v1, p0, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Landroid/animation/AnimatorSet;->playTogether(Ljava/util/Collection;)V

    .line 642
    return-void
.end method

.method public getChangingConfigurations()I
    .locals 1

    .line 634
    iget v0, p0, La/b/b/a/d$a;->a:I

    return v0
.end method

.method public newDrawable()Landroid/graphics/drawable/Drawable;
    .locals 2

    .line 624
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No constant state support for SDK < 24."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "res"    # Landroid/content/res/Resources;

    .line 629
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No constant state support for SDK < 24."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
