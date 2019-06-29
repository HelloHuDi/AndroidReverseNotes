.class Landroid/support/v4/widget/a$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/widget/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "b"
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v4/widget/a;


# direct methods
.method constructor <init>(Landroid/support/v4/widget/a;)V
    .locals 0

    .line 695
    iput-object p1, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 696
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 700
    iget-object v0, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    iget-boolean v1, v0, Landroid/support/v4/widget/a;->p:Z

    if-nez v1, :cond_0

    .line 701
    return-void

    .line 704
    :cond_0
    iget-boolean v1, v0, Landroid/support/v4/widget/a;->n:Z

    const/4 v2, 0x0

    if-eqz v1, :cond_1

    .line 705
    iput-boolean v2, v0, Landroid/support/v4/widget/a;->n:Z

    .line 706
    iget-object v0, v0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->h()V

    .line 709
    :cond_1
    iget-object v0, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    iget-object v0, v0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    .line 710
    .local v0, "scroller":Landroid/support/v4/widget/a$a;
    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->f()Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    invoke-virtual {v1}, Landroid/support/v4/widget/a;->b()Z

    move-result v1

    if-nez v1, :cond_2

    goto :goto_0

    .line 715
    :cond_2
    iget-object v1, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    iget-boolean v3, v1, Landroid/support/v4/widget/a;->o:Z

    if-eqz v3, :cond_3

    .line 716
    iput-boolean v2, v1, Landroid/support/v4/widget/a;->o:Z

    .line 717
    invoke-virtual {v1}, Landroid/support/v4/widget/a;->a()V

    .line 720
    :cond_3
    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->a()V

    .line 722
    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->b()I

    move-result v1

    .line 723
    .local v1, "deltaX":I
    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->c()I

    move-result v2

    .line 724
    .local v2, "deltaY":I
    iget-object v3, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    invoke-virtual {v3, v1, v2}, Landroid/support/v4/widget/a;->a(II)V

    .line 727
    iget-object v3, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    iget-object v3, v3, Landroid/support/v4/widget/a;->d:Landroid/view/View;

    invoke-static {v3, p0}, La/b/c/g/u;->a(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 728
    return-void

    .line 711
    .end local v1    # "deltaX":I
    .end local v2    # "deltaY":I
    :cond_4
    :goto_0
    iget-object v1, p0, Landroid/support/v4/widget/a$b;->a:Landroid/support/v4/widget/a;

    iput-boolean v2, v1, Landroid/support/v4/widget/a;->p:Z

    .line 712
    return-void
.end method
