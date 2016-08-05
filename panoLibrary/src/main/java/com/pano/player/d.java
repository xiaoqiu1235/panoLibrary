package com.pano.player;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

public class d {

	private static String strDefaultKey = "hsgn";
	public static String a = "7e29470af0d11c3185a04e93bff33e0058082b33cdda7f9fe86366de3566fe7c312c27c9255259c9a6cecd1e0affd662";
	public static String b = "0886a1f0ac47be1cbbb3698b75da870b8a5f293e1532d0f4aa2d783c7c1a63ba055262f89c2d1a0aae704f9ead1b07641f276609cfaf9f5555a1e8755ebea363c4e0f4089a7095f29911fe6facbc770e1e68c966bf85876345a793194f3172d2aa2d783c7c1a63bafd7cc395bbec8b1b890d6773a269c04b625ac81c4827430fa7305a04382b0f2600083b117e924470829d5b4560841aa52f9b094377084978b1a1bbd74a4a54ebe00620f7432d900ff41326af081993eab73c8044a647413388aa7fcb8afbc25749a4c87eb1bf5bff2692052718c32dff0a75231bda4b6ee974b7986001d62364bc3189841ec35a20cc89ed7fa64929f45ec2fe4d748112fdd659dbfb4d0bf73ef1023b69d1904f3db165352a8f961efda2e918154150628a1f78059f5cb3be7f55a1e8755ebea363d8f97f1259fdc1f733c7706b75398482213fcf79f361a1d300590d3cf2a4d477";
	public static String c = "iVBORw0KGgoAAAANSUhEUgAAAC0AAAAtCAYAAAA6GuKaAAAABHNCSVQICAgIfAhkiAAACSVJREFU" +
            "WIW9mXtsHPURx+e3u+c7n+2YOE6CE0pKEkiCYxKKRYG2UB4KlaC0FUWUPhC0UqUKqRVV1RZRoAVK" +
            "EaBCoaUPFKBtCmpaEiGhFlEEahIgJU6IMYed+P0632vv9m7v9nb395uZ/hEMiePdsxOHke6f3Znv" +
            "fH6zu/N7nICTME4k6mRLyyY9FrkYIpHzNSOylnVjOWhaMwjNACYEIosIc+DJQZLeAXDsNyKl6kHR" +
            "3u6fTO55mzs+sBYL2bvRdd8jIp6PEROT7yWkad7rjRzecMphveTwemUVthIqe36oAQNAdFS58Iw3" +
            "NrBxwWG5vz+K+cydhKq0AKyzwZdlJnUfd3XFFwY4ObxeVSu7F6KytUw55f95470dJwUsUyNXkFKp" +
            "kwZGJGJ2mblKiH6YHkqZk2P9V4dxiaAbbu/BLZFzNv5T0/Sm+Q6WpOwDWX2NfXqbPO8QaVou6jgV" +
            "aG1lsCzDjxun6aivEtHIRqHrl0A01il0Y8WH8UxOdbTv+saz2l+eM7Q81H2lvrZ9p5gHMBOm2LH/" +
            "rrnuTpA8IuvEMtBjG4XQ13M8erpeKunc2FRl37cMDaaQ1GFVlb3RXG4c6uqEXNy0WUTrr9Xi8Rs0" +
            "zVhHwMR9iS8ZGzpeqpnc3bdnHUqZneuTJ8KiLFr3c3akbVrDMSfO4Pe7L2LTvFqVSrfIUukhct09" +
            "zEjHxhKT8seUU9mu8ulv8NTUUmbWVXbqGuWWd6GSDr974OLwaiW21ynLemtOsMxM1fK/2c7Nuddy" +
            "IbkKS/mfovLHZtVDtKlS2SnTk1cxd0WkZW6R+exD/M7rpwWK4sTInXP56JCIZT73K2bW5gp8DHx6" +
            "aLmyrafCcpH09nMxexMnk8Ft0H3/nbNJqUrNChNJtlLfORHYmVbNFW4mJifsaaL03mHLvGFWAc/M" +
            "PFMbGF1lTt64EMDTJq30VUjo1spdziQfOybQ7elZQ6iqocDM7KeT311I4Gkr9Pd9uxY0EyH3J9o/" +
            "Gq05dW+tGD+X23YqgKdN5dN/qsWA6alHAODI8hK9am/oIKWfLg/1LK+V2M1OnCPzuTuUYz+npHrR" +
            "t+1tvpm6nZODZ9aK5cHBZvL90VBo1x3lrq64JnX9PBGJrgsTlJb5ZOPqjnRgwq6uuCoUHo8san1O" +
            "i9Q1suNtpUr5F8J1t4pYfQO2tG1D27ybmQNnYLFmTREL5hNhHCIaPdNtaenU9MbGzwohAsWYsEJ2" +
            "4dnA+wMDy9T69btEPLZcK9mXy2L2z5ouOkQs9k3Q9U5yrR26PXYNa8ZZyim/nN2zJ3CW9Zz8NkJl" +
            "BUIDgLEo/hlQhcJfQ18N234lELirq1m61R7Mm88DAGAp/yAR8bH9l1AVMk8AAGAh/Yxr5f/Lie11" +
            "QZpUKb0YxqNKhR2gnEroDChN867ABOnMC4SYZWZNTo49zMxMzFX0y49hxf6eqjpvf3CNcWriSQAA" +
            "YsqobPqPQZpoZm8Pf6+d/YC+1x/m5KXTX5lN3B1KXEfMLHPpH7uH311NRExSWpxJXvohQLm8/8N6" +
            "MzP3J9o5M3kbMXN19NCVs+nKycktoUtX5Q9pQtebg0YNACAMnpp5jROvN0baVj0gAIA99R+9eflX" +
            "hRBAjv0XsWzFrmk/3yu+xEweE1YFAPiLWm/0JLwqAKBu6cpfc+L1xpnaXoQzgpmDeDShN2hC041g" +
            "ZIZIyvRmXlXNZ18oYg3tzAxUqRS1SORIS6uLHjzar37Jyntkamwzlys/AQAwFi/5BMViDhGhVt9w" +
            "HracedlM7QZHeQCMgURCGBpTsAOAAHl6c3TmVSOV2g9VZ0AIAVo8vghITQAAsF8+boMaXXFWH4Fq" +
            "BQAAy0rWV6v1QtN08r0pvVLeN9NfGvEogAheiDGjBiiLwdAAmmssO24onZ1FyqR+zgCg12uXy6K5" +
            "gwFAa1h8qz8xfNHRvt74eIfesOg2AADNyv8Do8ZlAACYSd0l1m7KHKcdqS5lEQpdAVUp7w39WjOp" +
            "O2aN3b5dp1LpNZJ+CgAAJ8d/y8xMSCV0rAe5XPyWtIv3I6LJzKwyqacBAMj3RlXF2c0BEw0WMj+o" +
            "0T0OgLJyfwtzonJx1n0aAEClr2+F8rwp18r/AQBAFXKPH92n6YOfMnNPAwDITPZR8twk7917RpCm" +
            "sks7QnlKhZ2AyeQPQ50IS2xOBCbxeno2oPKG0Ctv5eHhmD8xvFkWi3ejUk9hpXiPnx35FA8Px1S1" +
            "+HtZdQ7x4PtnB2lxItGC0s8FsjAzZlI/09B19zAEtxghtCZfGjcH3Y92dPRqjnkhSmyklSve0hct" +
            "/gIr9YpTzD6GSr4sok1X4Mq2V4E4YqQOfVqsObc/SItamm4SRmRJ0H0AAKrYewT390dpZVuPVt8Q" +
            "XAGlJkV2aLNYsS4XJuhPjV8o6huuF3WRdajVxTTfszWWPZpTfkG0rUqExXJfXxOu/uRBPRJdHegj" +
            "/XHR23dkT4qpiQfCXhFmZj+TeTYs6cmaKmSeqMUgM8nffDSCwd5zSIVveYiZ1eDgracC2B47dGPN" +
            "01ci6b93YNMxgX4+HbraY2ZWiFV3YuKahQSWqYErEFW5ZpWtzI7jgr2e/Ruwxj7xSMXJUbmpWxYC" +
            "WBXzXydmew45fT6c2Dz7qAcG7qslcESEWRWt33Ey2XoisFwYPk3ZxcfnerDpj008Giz25pv1WLG7" +
            "5qjF6PsjaGV/5IyPr5wLbCU70obFzPdRqdDl8DEFsksJ3vuvRUfrHDeVet37NhrnbtqtGZHgo6gZ" +
            "RoR54VV3s1K7iOg99t1spOh4Mh6PilhsqWYY54po5HMQqbsUNL01cG83wxCVrSe6Py82dR6o6Vwe" +
            "693CiIEnP7XLQ8xEkj/oCCdyvk2Ivjs2dN1cCwcAANn+7i8SYs1jslNhROSr1OTX5gU8bWr08LWk" +
            "ZP7jBEaFRZVMfvmEgKfNHz68WVWdfR8LsOMc9JOjF5wU8LRxd3eDtHK/ZDo1rwsReVjKP8x9ffP+" +
            "q6Sm+UNDm/yi9TwReQsDi1JV7O1+cqxzwWFnmpceP8+3zEfQdQfn2xmImdHzhtA0H/Uzk+efSP65" +
            "tsxZjbu7G9TSxRdALH6JiNZfoBnaKtAjS4SABhZaBJiQmcqgKC+kHGNZ3U+Ibxic7xLL2ssnmvf/" +
            "2ri1o9M0rhwAAAAASUVORK5CYII=";
	public static String d = "61a9f2ebb24717cf7436fc195630d4d363d6329fbc64647490af606f1760c921f25f6f8e2f4f61f549771cb090d792ea6ad47cb9cddb8d439edc51fd38f5baee678e8d92c919535f64cb450bf455bead010b28aa92baaa476b0b77169eab45b948afecd815e5f4e3f04c915ae28110527a48c9761a212b566cb9fe6f1455a2dca597099177b9f511dd43a1d50f9c9ebec88ff60b2473f139ad8df0c8dc51bdd0af11fca30bcc3a628c3125f9ac70f4f1e9364373b31a57515483724161cb4d7c4e6fb59ee741d365b36a064b47a4af533df32400043c78699998aaa33428555564316b00dd4c6458060801e626ed92245c55df3672bdffd49c1a3f5729e9174f81c17f137f001816f8dbb1f6cc1d910e8ff7f01a272b2ecd394db1521e9c8cf9f91160f47dec2ca830bb68b756f70564eebcdd2b5700c51ffaf39de6f8bc7f2301d187073687f6eab57942237aee73e65710de82859ef4c74f3625c92d8919157fb87bc82334e48028823600bfcc68fb0cc350a63821facc9908dc6bb921ead97a51602b4d29a3f027566a2676a4c830a4bd0612639879633a75d7de34ee2911695af3f6a7fecda750933fbe2ac7e30fe094ec6d6e1a917265e117395310889998ae7bb1aaf52a038fba3d90bd9aa823f739e7e7d98e2947fb6262990cc514da520e3b6fa4a73124cbde5ba35ef27b8d4d751910a37e871c89216ad88113d0a620213fc22a22ca8961024049b7601a584c96ae087963a28eac9d70196ea4e96e2a769416e34eca9404e469c23a1c161c0ffcda3cadcdfde3b1906a79bc5ecb171432ece0b6b3d2177e5c05dbeddd5c709bfd023673e0e8621a591ffea54b0fa2d62816f343fcdd5c2cf18a9487b68c066f8dbb0503b1c41e5b720b93bb32c234197122c4638a477e7ddb09c34683cbfe5e163109340a0bf0fbc21b4fc80f5ba1f0528260fa9e51be5623bec6a9c503a1988b53db145e8ce1863c877d8fcc3685e06490085145b32af41a4e192a463baf36594d5dee15395d8d006a4791647425559223dd60cb9f3fdc30ff91fb54a84b8964eaae5a1239972d77fca5018503d022ea1e89dd03fd021de5cfcf0af46f90b2c752d17869d553a9181463a3aa01e007454db1a6afdf259ccff163ea8154c7ad3e4d2752ae82edf5c1acf609d5323e58f820769d7bc3bf0e2c69be8c9cf438e1202b5751f1bdbbd5b54f1d254f26671c4716f6e21a33a39fd8417da20d13c39bbcbe3df0b7c01d521493990c425742957142416853769951f3a478b6202dd88c29f62c5dfc951aa1a78aab5f4adefab861b47f762864acb9a905a0037dec2800090f842ec91ca094827f6b2e46477590a4e6122b4a573ff9b57e38a932144359f8d548d53f15672efc38a96293e0f4e5e53bcc742fd92ea9f3abb7d505ea74199340dd86104417c2271f44b46cf17ad39313edcd049e21ff1516f1381ac67deac786e5a80a12d0b1e2c61fbb71ebc9413dafbb940a45100105ed03fe19f364f9ffcf361c51fd2ba521dedd28e352561801300854d7228de09d43eeb24f5ddd2a8bf759dc888361b37f7bdf2e0d82e413758b494897e58f5df70993ccc6f3c0c186ba1b40a1523b0d2e7c055a01f58e4afe60835d65251bb7e992afab2a010853c04d210315b54d8753754e9432f40323e41b896ad4e6f6ff52b6fe1dc8ccfb613df573b9973663c3c9e5446dfe49bc44b73d24227d7ffe42629bea983139e4e99df7e2851f984642a203681402397ce7af71ef39482c2fedebaa39c616b9f2655a33394ba9061651bc7da7d09767a97a200b7f7fc1b360f9ed8d48fc0cac423149c61d6aa72291bb91a1d718fac6a5cebb7493e98af78304a7164ce8129176e442d7b8b8bca3759f32ea6eab78e8ba95c0922631913499f824a7cccf424e853a568c9189864a4ed8a2f91d08c0760237fc1127449d86f07e18b9563f0960cd7698ab770c76809b929b222a12f2d3bf4e4decad275da4fe19b8192a8d63ca893a26dbc17d944312731db50ee3aad59e4027e09a66fc8f9c64eb32972247a336cf1088dd30a12b0a646ebcbddb960227af52a799faa0bc559cf1a1193c5685954ecd67928437bc044762e11b07aed226516824493b9f6d2b762a5db5bf99c689b5d7289daaaa142df40cc9c16fb158eb12b281ee88307b71dacd21b4037569460934e31d4e1f1b7c4f4fa3e330ffbefffa8d245cba2363e13b76a65d413d8c252d225b96ed117622c9421ad2035fa637b17b161eba4f52c7e1fa9524bb8c6aff8cc983e52d95acca51e1c7624865576f16b72c89e75e56ce339f7b8f17fa0f688d2dc2b8c9a2af2ef32a4671350b58a0551e37294dfa490d37cafa69f5d98415dc468d3736b1db9052847dcf2fd887c178f371f9703ea2ce4371aecbe0014a8feec529faea9818de99b74cfa53cfa3dbc9b3d1cc3898df26c556929467c8f8474dddae0f37b385689b350313eb119cd8193a4fc4b1d84b49b68ce208575a3761e1ccbc962025b04d5cedf4a20ef7ace0665768789da622eb722172a868b0767f82706c18a2dec6fe4b2752d3dfc98814935ff5dcac0965cfbb7da75cfc54273d06e1139948d76538e3fc9fb6122b4ba781bf9bf2d86e5fc3c89ea41e9b49d1a0813f17be1e3feab65c2f78e2abdc0d056ea25f2aec29ce96e0ab76b7ead4843853cc37163c070b6f6e95a7b09ef69a1bcd1624881d9c4bc0616123b68f51f1077d5f591d4c100695aa667a3acb26dfe1c239b75734d75728c1a7f5e38511ff63b7ea4dc35e80cf11911e5a6164e8154f46578973bdb3c2a37b0237abc93d930f9d58326487ce52e1ed87d4196bd634419f39278b39aefd2f25bd4dbdb61";
	private Cipher e = null;

	public static byte[] f(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	public d() throws Exception {
		this(strDefaultKey);
	}

	public d(String strKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = i(strKey.getBytes());
		e = Cipher.getInstance("DES");
		e.init(Cipher.DECRYPT_MODE, key);
	}

	public byte[] g(byte[] arrB) throws Exception {
		return e.doFinal(arrB);
	}

	public String h(String strIn) throws Exception {
		try {
			return new String(g(f(strIn)));
		} catch (Exception e) {
			return "";
		}
	}

	private Key i(byte[] arrBTmp) throws Exception {
		byte[] arrB = new byte[8];
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

}