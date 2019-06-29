.class La/b/c/g/y;
.super Landroid/animation/AnimatorListenerAdapter;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/g/A;->a(Landroid/view/View;La/b/c/g/B;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:La/b/c/g/B;

.field final synthetic b:Landroid/view/View;

.field final synthetic c:La/b/c/g/A;


# direct methods
.method constructor <init>(La/b/c/g/A;La/b/c/g/B;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/g/A;

    .line 740
    iput-object p1, p0, La/b/c/g/y;->c:La/b/c/g/A;

    iput-object p2, p0, La/b/c/g/y;->a:La/b/c/g/B;

    iput-object p3, p0, La/b/c/g/y;->b:Landroid/view/View;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 743
    iget-object v0, p0, La/b/c/g/y;->a:La/b/c/g/B;

    iget-object v1, p0, La/b/c/g/y;->b:Landroid/view/View;

    invoke-interface {v0, v1}, La/b/c/g/B;->a(Landroid/view/View;)V

    .line 744
    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 748
    iget-object v0, p0, La/b/c/g/y;->a:La/b/c/g/B;

    iget-object v1, p0, La/b/c/g/y;->b:Landroid/view/View;

    invoke-interface {v0, v1}, La/b/c/g/B;->b(Landroid/view/View;)V

    .line 749
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 753
    iget-object v0, p0, La/b/c/g/y;->a:La/b/c/g/B;

    iget-object v1, p0, La/b/c/g/y;->b:Landroid/view/View;

    invoke-interface {v0, v1}, La/b/c/g/B;->c(Landroid/view/View;)V

    .line 754
    return-void
.end method
