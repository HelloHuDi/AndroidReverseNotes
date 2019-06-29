.class La/b/c/g/z;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/g/A;->a(La/b/c/g/D;)La/b/c/g/A;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:La/b/c/g/D;

.field final synthetic b:Landroid/view/View;

.field final synthetic c:La/b/c/g/A;


# direct methods
.method constructor <init>(La/b/c/g/A;La/b/c/g/D;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/g/A;

    .line 778
    iput-object p1, p0, La/b/c/g/z;->c:La/b/c/g/A;

    iput-object p2, p0, La/b/c/g/z;->a:La/b/c/g/D;

    iput-object p3, p0, La/b/c/g/z;->b:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2
    .param p1, "valueAnimator"    # Landroid/animation/ValueAnimator;

    .line 781
    iget-object v0, p0, La/b/c/g/z;->a:La/b/c/g/D;

    iget-object v1, p0, La/b/c/g/z;->b:Landroid/view/View;

    invoke-interface {v0, v1}, La/b/c/g/D;->a(Landroid/view/View;)V

    .line 782
    return-void
.end method
