.class Landroid/support/v7/widget/za;
.super La/b/c/g/C;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/Aa;->a(IJ)La/b/c/g/A;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private a:Z

.field final synthetic b:I

.field final synthetic c:Landroid/support/v7/widget/Aa;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/Aa;I)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/Aa;

    .line 569
    iput-object p1, p0, Landroid/support/v7/widget/za;->c:Landroid/support/v7/widget/Aa;

    iput p2, p0, Landroid/support/v7/widget/za;->b:I

    invoke-direct {p0}, La/b/c/g/C;-><init>()V

    .line 570
    const/4 p2, 0x0

    iput-boolean p2, p0, Landroid/support/v7/widget/za;->a:Z

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 586
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/za;->a:Z

    .line 587
    return-void
.end method

.method public b(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 579
    iget-boolean v0, p0, Landroid/support/v7/widget/za;->a:Z

    if-nez v0, :cond_0

    .line 580
    iget-object v0, p0, Landroid/support/v7/widget/za;->c:Landroid/support/v7/widget/Aa;

    iget-object v0, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    iget v1, p0, Landroid/support/v7/widget/za;->b:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 582
    :cond_0
    return-void
.end method

.method public c(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .line 574
    iget-object v0, p0, Landroid/support/v7/widget/za;->c:Landroid/support/v7/widget/Aa;

    iget-object v0, v0, Landroid/support/v7/widget/Aa;->a:Landroid/support/v7/widget/Toolbar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 575
    return-void
.end method
