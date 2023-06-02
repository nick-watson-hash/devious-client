import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lmg;"
   )
   @Export("coord2")
   public final Coord coord2;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lmg;"
   )
   @Export("coord1")
   public final Coord coord1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -510334465
   )
   @Export("screenX")
   int screenX;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1878554167
   )
   @Export("screenY")
   int screenY;

   @ObfuscatedSignature(
      descriptor = "(Lmg;Lmg;)V"
   )
   AbstractWorldMapIcon(Coord var1, Coord var2) {
      this.coord1 = var1;
      this.coord2 = var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1551656659"
   )
   @Export("getElement")
   public abstract int getElement();

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)Lks;",
      garbageValue = "1263568545"
   )
   @Export("getLabel")
   abstract WorldMapLabel getLabel();

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-44"
   )
   @Export("getSubWidth")
   abstract int getSubWidth();

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-96"
   )
   @Export("getSubHeight")
   abstract int getSubHeight();

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "117"
   )
   @Export("fitsScreen")
   boolean fitsScreen(int var1, int var2) {
      if (this.elementFitsScreen(var1, var2)) {
         return true;
      } else {
         return this.labelFitsScreen(var1, var2);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "84"
   )
   @Export("hasValidElement")
   boolean hasValidElement() {
      return this.getElement() >= 0;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1890405621"
   )
   @Export("elementFitsScreen")
   boolean elementFitsScreen(int var1, int var2) {
      if (!this.hasValidElement()) {
         return false;
      } else {
         WorldMapElement var3 = class147.WorldMapElement_get(this.getElement());
         int var4 = this.getSubWidth();
         int var5 = this.getSubHeight();
         switch (var3.horizontalAlignment.value) {
            case 0:
               if (var1 > this.screenX - var4 && var1 <= this.screenX) {
                  break;
               }

               return false;
            case 1:
               if (var1 >= this.screenX && var1 < var4 + this.screenX) {
                  break;
               }

               return false;
            case 2:
               if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
                  return false;
               }
         }

         switch (var3.verticalAlignment.value) {
            case 0:
               if (var2 >= this.screenY - var5 / 2 && var2 <= var5 / 2 + this.screenY) {
                  break;
               }

               return false;
            case 1:
               if (var2 >= this.screenY && var2 < var5 + this.screenY) {
                  break;
               }

               return false;
            case 2:
               if (var2 <= this.screenY - var5 || var2 > this.screenY) {
                  return false;
               }
         }

         return true;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(IIB)Z",
      garbageValue = "-16"
   )
   @Export("labelFitsScreen")
   boolean labelFitsScreen(int var1, int var2) {
      WorldMapLabel var3 = this.getLabel();
      if (var3 == null) {
         return false;
      } else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
         return var2 >= this.screenY && var2 <= var3.height + this.screenY;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-61"
   )
   public static void method5525() {
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
   }
}
