import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fs")
public class class131 {
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)Lqx;",
      garbageValue = "-20"
   )
   public static class424 method3130() {
      synchronized(class424.field4659) {
         if (class424.field4658 == 0) {
            return new class424();
         } else {
            class424.field4659[--class424.field4658].method8167();
            return class424.field4659[class424.field4658];
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "1883190484"
   )
   static int method3129(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var4 = class165.getWidget(var3);
      } else {
         var4 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
      }

      if (var0 == ScriptOpcodes.CC_SETPOSITION) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         class144.invalidateWidget(var4);
         ScriptFrame.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == ScriptOpcodes.CC_SETSIZE) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         class144.invalidateWidget(var4);
         ScriptFrame.client.alignWidget(var4);
         if (var3 != -1 && var4.type == 0) {
            WallDecoration.revalidateWidgetScroll(VerticalAlignment.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if (var0 == ScriptOpcodes.CC_SETHIDE) {
         boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         if (var5 != var4.isHidden) {
            var4.isHidden = var5;
            class144.invalidateWidget(var4);
         }

         return 1;
      } else if (var0 == ScriptOpcodes.CC_SETNOCLICKTHROUGH) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else if (var0 == ScriptOpcodes.CC_SETNOSCROLLTHROUGH) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
