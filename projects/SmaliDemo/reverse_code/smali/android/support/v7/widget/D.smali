.class Landroid/support/v7/widget/D;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/C$b;-><init>(Landroid/support/v7/widget/C;Landroid/content/Context;Landroid/util/AttributeSet;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/C;

.field final synthetic b:Landroid/support/v7/widget/C$b;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/C$b;Landroid/support/v7/widget/C;)V
    .locals 0
    .param p1, "this$1"    # Landroid/support/v7/widget/C$b;

    .line 729
    iput-object p1, p0, Landroid/support/v7/widget/D;->b:Landroid/support/v7/widget/C$b;

    iput-object p2, p0, Landroid/support/v7/widget/D;->a:Landroid/support/v7/widget/C;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView<",
            "*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .line 732
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Landroid/support/v7/widget/D;->b:Landroid/support/v7/widget/C$b;

    iget-object v0, v0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v0, p3}, Landroid/widget/Spinner;->setSelection(I)V

    .line 733
    iget-object v0, p0, Landroid/support/v7/widget/D;->b:Landroid/support/v7/widget/C$b;

    iget-object v0, v0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getOnItemClickListener()Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 734
    iget-object v0, p0, Landroid/support/v7/widget/D;->b:Landroid/support/v7/widget/C$b;

    iget-object v1, v0, Landroid/support/v7/widget/C$b;->N:Landroid/support/v7/widget/C;

    iget-object v0, v0, Landroid/support/v7/widget/C$b;->L:Landroid/widget/ListAdapter;

    .line 735
    invoke-interface {v0, p3}, Landroid/widget/ListAdapter;->getItemId(I)J

    move-result-wide v2

    invoke-virtual {v1, p2, p3, v2, v3}, Landroid/widget/Spinner;->performItemClick(Landroid/view/View;IJ)Z

    .line 737
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/D;->b:Landroid/support/v7/widget/C$b;

    invoke-virtual {v0}, Landroid/support/v7/widget/U;->dismiss()V

    .line 738
    return-void
.end method
