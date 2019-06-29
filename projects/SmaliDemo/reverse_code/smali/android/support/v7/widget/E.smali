.class Landroid/support/v7/widget/E;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/C$b;->c()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/C$b;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/C$b;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/widget/C$b;

    .line 818
    iput-object p1, p0, Landroid/support/v7/widget/E;->a:Landroid/support/v7/widget/C$b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .line 821
    iget-object v0, p0, Landroid/support/v7/widget/E;->a:Landroid/support/v7/widget/C$b;

    iget-object v1, v0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/C$b;->b(Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 822
    iget-object v0, p0, Landroid/support/v7/widget/E;->a:Landroid/support/v7/widget/C$b;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->dismiss()V

    goto :goto_0

    .line 824
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/E;->a:Landroid/support/v7/widget/C$b;

    invoke-virtual {v0}, Landroid/support/v7/widget/C$b;->l()V

    .line 828
    iget-object v0, p0, Landroid/support/v7/widget/E;->a:Landroid/support/v7/widget/C$b;

    invoke-static {v0}, Landroid/support/v7/widget/C$b;->a(Landroid/support/v7/widget/C$b;)V

    .line 830
    :goto_0
    return-void
.end method
