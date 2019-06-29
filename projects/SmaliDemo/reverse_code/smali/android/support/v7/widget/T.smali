.class Landroid/support/v7/widget/T;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/widget/AdapterView$OnItemSelectedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/U;->l()I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/U;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/U;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/U;

    .line 1166
    iput-object p1, p0, Landroid/support/v7/widget/T;->a:Landroid/support/v7/widget/U;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
    .param p2, "view"    # Landroid/view/View;
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

    .line 1171
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v0, -0x1

    if-eq p3, v0, :cond_0

    .line 1172
    iget-object v0, p0, Landroid/support/v7/widget/T;->a:Landroid/support/v7/widget/U;

    iget-object v0, v0, Landroid/support/v7/widget/U;->f:Landroid/support/v7/widget/N;

    .line 1174
    .local v0, "dropDownList":Landroid/support/v7/widget/N;
    if-eqz v0, :cond_0

    .line 1175
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/N;->setListSelectionHidden(Z)V

    .line 1178
    .end local v0    # "dropDownList":Landroid/support/v7/widget/N;
    :cond_0
    return-void
.end method

.method public onNothingSelected(Landroid/widget/AdapterView;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView<",
            "*>;)V"
        }
    .end annotation

    .line 1182
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    return-void
.end method
