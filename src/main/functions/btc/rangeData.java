package main.functions.btc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author captainjuk
 * 
 */

public class rangeData {
  public List<HexRange> ranges = new ArrayList<>();

  public rangeData() {
    Puzzle();
  }

  public void Puzzle() {
    //{bits, start, end}
    String[][] rangeData = {
        { "1", "0", "1" },
        { "2", "2", "3" },
        { "3", "4", "7" },
        { "4", "8", "f" },
        { "5", "10", "1f" },
        { "6", "20", "3f" },
        { "7", "40", "7f" },
        { "8", "80", "ff" },
        { "9", "100", "1ff" },
        { "10", "200", "3ff" },
        { "11", "400", "7ff" },
        { "12", "800", "fff" },
        { "13", "1000", "1fff" },
        { "14", "2000", "3fff" },
        { "15", "4000", "7fff" },
        { "16", "8000", "ffff" },
        { "17", "10000", "1ffff" },
        { "18", "20000", "3ffff" },
        { "19", "40000", "7ffff" },
        { "20", "80000", "fffff" },
        { "21", "100000", "1fffff" },
        { "22", "200000", "3fffff" },
        { "23", "400000", "7fffff" },
        { "24", "800000", "ffffff" },
        { "25", "1000000", "1ffffff" },
        { "26", "2000000", "3ffffff" },
        { "27", "4000000", "7ffffff" },
        { "28", "8000000", "ffffff" },
        { "29", "10000000", "1fffffff" },
        { "30", "20000000", "3fffffff" },
        { "31", "40000000", "7fffffff" },
        { "32", "80000000", "ffffffff" },
        { "33", "100000000", "1ffffffff" },
        { "34", "200000000", "3ffffffff" },
        { "35", "400000000", "7ffffffff" },
        { "36", "800000000", "fffffffff" },
        { "37", "1000000000", "1fffffffff" },
        { "38", "2000000000", "3fffffffff" },
        { "39", "4000000000", "7fffffffff" },
        { "40", "8000000000", "ffffffffff" },
        { "41", "10000000000", "1ffffffffff" },
        { "42", "20000000000", "3ffffffffff" },
        { "43", "40000000000", "7ffffffffff" },
        { "44", "80000000000", "fffffffffff" },
        { "45", "100000000000", "1fffffffffff" },
        { "46", "200000000000", "3fffffffffff" },
        { "47", "400000000000", "7fffffffffff" },
        { "48", "800000000000", "ffffffffffff" },
        { "49", "1000000000000", "1ffffffffffff" },
        { "50", "2000000000000", "3ffffffffffff" },
        { "51", "4000000000000", "7ffffffffffff" },
        { "52", "8000000000000", "fffffffffffff" },
        { "53", "10000000000000", "1fffffffffffff" },
        { "54", "20000000000000", "3fffffffffffff" },
        { "55", "40000000000000", "7fffffffffffff" },
        { "56", "80000000000000", "ffffffffffffff" },
        { "57", "100000000000000", "1ffffffffffffff" },
        { "58", "200000000000000", "3ffffffffffffff" },
        { "59", "400000000000000", "7ffffffffffffff" },
        { "60", "800000000000000", "fffffffffffffff" },
        { "61", "1000000000000000", "1fffffffffffffff" },
        { "62", "2000000000000000", "3fffffffffffffff" },
        { "63", "4000000000000000", "7fffffffffffffff" },
        { "64", "8000000000000000", "ffffffffffffffff" },
        { "65", "10000000000000000", "1ffffffffffffffff" },
        { "66", "20000000000000000", "3ffffffffffffffff" },
        { "67", "40000000000000000", "7ffffffffffffffff" },
        { "68", "80000000000000000", "fffffffffffffffff" },
        { "69", "100000000000000000", "1fffffffffffffffff" },
        { "70", "200000000000000000", "3fffffffffffffffff" },
        { "71", "400000000000000000", "7fffffffffffffffff" },
        { "72", "800000000000000000", "ffffffffffffffffff" },
        { "73", "1000000000000000000", "1ffffffffffffffffff" },
        { "74", "2000000000000000000", "3ffffffffffffffffff" },
        { "75", "4000000000000000000", "7ffffffffffffffffff" },
        { "76", "8000000000000000000", "fffffffffffffffffff" },
        { "77", "10000000000000000000", "1fffffffffffffffffff" },
        { "78", "20000000000000000000", "3fffffffffffffffffff" },
        { "79", "40000000000000000000", "7fffffffffffffffffff" },
        { "80", "80000000000000000000", "ffffffffffffffffffff" },
        { "81", "100000000000000000000", "1ffffffffffffffffffff" },
        { "82", "200000000000000000000", "3ffffffffffffffffffff" },
        { "83", "400000000000000000000", "7ffffffffffffffffffff" },
        { "84", "800000000000000000000", "fffffffffffffffffffff" },
        { "85", "1000000000000000000000", "1fffffffffffffffffffff" },
        { "86", "2000000000000000000000", "3fffffffffffffffffffff" },
        { "87", "4000000000000000000000", "7fffffffffffffffffffff" },
        { "88", "8000000000000000000000", "ffffffffffffffffffffff" },
        { "89", "10000000000000000000000", "1ffffffffffffffffffffff" },
        { "90", "20000000000000000000000", "3ffffffffffffffffffffff" },
        { "91", "40000000000000000000000", "7ffffffffffffffffffffff" },
        { "92", "80000000000000000000000", "fffffffffffffffffffffff" },
        { "93", "100000000000000000000000", "1fffffffffffffffffffffff" },
        { "94", "200000000000000000000000", "3fffffffffffffffffffffff" },
        { "95", "400000000000000000000000", "7fffffffffffffffffffffff" },
        { "96", "800000000000000000000000", "ffffffffffffffffffffffff" },
        { "97", "1000000000000000000000000", "1ffffffffffffffffffffffff" },
        { "98", "2000000000000000000000000", "3ffffffffffffffffffffffff" },
        { "99", "4000000000000000000000000", "7ffffffffffffffffffffffff" },
        { "100", "8000000000000000000000000", "fffffffffffffffffffffffff" },
        { "101", "10000000000000000000000000", "1fffffffffffffffffffffffff" },
        { "102", "20000000000000000000000000", "3fffffffffffffffffffffffff" },
        { "103", "40000000000000000000000000", "7fffffffffffffffffffffffff" },
        { "104", "80000000000000000000000000", "ffffffffffffffffffffffffff" },
        { "105", "100000000000000000000000000", "1ffffffffffffffffffffffffff" },
        { "106", "200000000000000000000000000", "3ffffffffffffffffffffffffff" },
        { "107", "400000000000000000000000000", "7ffffffffffffffffffffffffff" },
        { "108", "800000000000000000000000000", "fffffffffffffffffffffffffff" },
        { "109", "1000000000000000000000000000", "1fffffffffffffffffffffffffff" },
        { "110", "2000000000000000000000000000", "3fffffffffffffffffffffffffff" },
        { "111", "4000000000000000000000000000", "7fffffffffffffffffffffffffff" },
        { "112", "8000000000000000000000000000", "ffffffffffffffffffffffffffff" },
        { "113", "10000000000000000000000000000", "1ffffffffffffffffffffffffffff" },
        { "114", "20000000000000000000000000000", "3ffffffffffffffffffffffffffff" },
        { "115", "40000000000000000000000000000", "7ffffffffffffffffffffffffffff" },
        { "116", "80000000000000000000000000000", "fffffffffffffffffffffffffffff" },
        { "117", "100000000000000000000000000000", "1fffffffffffffffffffffffffffff" },
        { "118", "200000000000000000000000000000", "3fffffffffffffffffffffffffffff" },
        { "119", "400000000000000000000000000000", "7fffffffffffffffffffffffffffff" },
        { "120", "800000000000000000000000000000", "ffffffffffffffffffffffffffffff" },
    };

    // Loop para adicionar as faixas ao array de ranges
    for (String[] range : rangeData) {
      int bits = Integer.parseInt(range[0]);
      String startHex = range[1];
      String endHex = range[2];
      ranges.add(new HexRange(bits, startHex, endHex));
    }
  }
}