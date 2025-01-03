package main.functions.btc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author captainjuk
 * 
 */

public class dataPuzzle {
  
  //{bits, startRange, endRange, PublicKey, endKey}
  private static final String[][] rangeData = {
    {"1", "1", "1",  "0279be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798", "1BgGZ9tcN4rm9KBzDn7KprQz87SZ26SAMH"},
    {"2", "2", "3", "02f9308a019258c31049344f85f89d5229b531c845836f99b08601f113bce036f9", "1CUNEBjYrCn2y1SdiUMohaKUi4wpP326Lb"},
    {"3", "4", "7", "025cbdf0646e5db4eaa398f365f2ea7a0e3d419b7e0330e39ce92bddedcac4f9bc", "19ZewH8Kk1PDbSNdJ97FP4EiCjTRaZMZQA"},
    {"4", "8", "f", "022f01e5e15cca351daff3843fb70f3c2f0a1bdd05e5af888a67784ef3e10a2a01", "1EhqbyUMvvs7BfL8goY6qcPbD6YKfPqb7e"},
    {"5", "10", "1f", "02352bbf4a4cdd12564f93fa332ce333301d9ad40271f8107181340aef25be59d5", "1E6NuFjCi27W5zoXg8TRdcSRq84zJeBW3k"},
    {"6", "20", "3f", "03f2dac991cc4ce4b9ea44887e5c7c0bce58c80074ab9d4dbaeb28531b7739f530", "1PitScNLyp2HCygzadCh7FveTnfmpPbfp8"},
    {"7", "40", "7f", "0296516a8f65774275278d0d7420a88df0ac44bd64c7bae07c3fe397c5b3300b23", "1McVt1vMtCC7yn5b9wgX1833yCcLXzueeC"},
    {"8", "80", "ff", "0308bc89c2f919ed158885c35600844d49890905c79b357322609c45706ce6b514", "1M92tSqNmQLYw33fuBvjmeadirh1ysMBxK"},
    {"9", "100", "1ff", "0243601d61c836387485e9514ab5c8924dd2cfd466af34ac95002727e1659d60f7", "1CQFwcjw1dwhtkVWBttNLDtqL7ivBonGPV"},
    {"10", "200", "3ff", "03a7a4c30291ac1db24b4ab00c442aa832f7794b5a0959bec6e8d7fee802289dcd", "1LeBZP5QCwwgXRtmVUvTVrraqPUokyLHqe"},
    {"11", "400", "7ff", "038b05b0603abd75b0c57489e451f811e1afe54a8715045cdf4888333f3ebc6e8b", "1PgQVLmst3Z314JrQn5TNiys8Hc38TcXJu"},
    {"12", "800", "fff", "038b00fcbfc1a203f44bf123fc7f4c91c10a85c8eae9187f9d22242b4600ce781c", "1DBaumZxUkM4qMQRt2LVWyFJq5kDtSZQot"},
    {"13", "1000", "1fff", "03aadaaab1db8d5d450b511789c37e7cfeb0eb8b3e61a57a34166c5edc9a4b869d", "1Pie8JkxBT6MGPz9Nvi3fsPkr2D8q3GBc1"},
    {"14", "2000", "3fff", "03b4f1de58b8b41afe9fd4e5ffbdafaeab86c5db4769c15d6e6011ae7351e54759", "1ErZWg5cFCe4Vw5BzgfzB74VNLaXEiEkhk"},
    {"15", "4000", "7fff", "02fea58ffcf49566f6e9e9350cf5bca2861312f422966e8db16094beb14dc3df2c", "1QCbW9HWnwQWiQqVo5exhAnmfqKRrCRsvW"},
    {"16", "8000", "ffff", "029d8c5d35231d75eb87fd2c5f05f65281ed9573dc41853288c62ee94eb2590b7a", "1BDyrQ6WoF8VN3g9SAS1iKZcPzFfnDVieY"},
    {"17", "10000", "1ffff", "033f688bae8321b8e02b7e6c0a55c2515fb25ab97d85fda842449f7bfa04e128c3", "1HduPEXZRdG26SUT5Yk83mLkPyjnZuJ7Bm"},
    {"18", "20000", "3ffff", "020ce4a3291b19d2e1a7bf73ee87d30a6bdbc72b20771e7dfff40d0db755cd4af1", "1GnNTmTVLZiqQfLbAdp9DVdicEnB5GoERE"},
    {"19", "40000", "7ffff", "0385663c8b2f90659e1ccab201694f4f8ec24b3749cfe5030c7c3646a709408e19", "1NWmZRpHH4XSPwsW6dsS3nrNWfL1yrJj4w"},
    {"20", "80000", "fffff", "033c4a45cbd643ff97d77f41ea37e843648d50fd894b864b0d52febc62f6454f7c", "1HsMJxNiV7TLxmoF6uJNkydxPFDog4NQum"},
    {"21", "100000", "1fffff", "031a746c78f72754e0be046186df8a20cdce5c79b2eda76013c647af08d306e49e", "14oFNXucftsHiUMY8uctg6N487riuyXs4h"},
    {"22", "200000", "3fffff", "023ed96b524db5ff4fe007ce730366052b7c511dc566227d929070b9ce917abb43", "1CfZWK1QTQE3eS9qn61dQjV89KDjZzfNcv"},
    {"23", "400000", "7fffff", "03f82710361b8b81bdedb16994f30c80db522450a93e8e87eeb07f7903cf28d04b", "1L2GM8eE7mJWLdo3HZS6su1832NX2txaac"},
    {"24", "800000", "ffffff", "036ea839d22847ee1dce3bfc5b11f6cf785b0682db58c35b63d1342eb221c3490c", "1rSnXMr63jdCuegJFuidJqWxUPV7AtUf7"},
    {"25", "1000000", "1ffffff", "03057fbea3a2623382628dde556b2a0698e32428d3cd225f3bd034dca82dd7455a", "15JhYXn6Mx3oF4Y7PcTAv2wVVAuCFFQNiP"},
    {"26", "2000000", "3ffffff", "024e4f50a2a3eccdb368988ae37cd4b611697b26b29696e42e06d71368b4f3840f", "1JVnST957hGztonaWK6FougdtjxzHzRMMg"},
    {"27", "4000000", "7ffffff", "031a864bae3922f351f1b57cfdd827c25b7e093cb9c88a72c1cd893d9f90f44ece", "128z5d7nN7PkCuX5qoA4Ys6pmxUYnEy86k"},
    {"28", "8000000", "fffffff", "03e9e661838a96a65331637e2a3e948dc0756e5009e7cb5c36664d9b72dd18c0a7", "12jbtzBb54r97TCwW3G1gCFoumpckRAPdY"},
    {"29", "10000000", "1fffffff", "026caad634382d34691e3bef43ed4a124d8909a8a3362f91f1d20abaaf7e917b36", "19EEC52krRUK1RkUAEZmQdjTyHT7Gp1TYT"},
    {"30", "20000000", "3fffffff", "030d282cf2ff536d2c42f105d0b8588821a915dc3f9a05bd98bb23af67a2e92a5b", "1LHtnpd8nU5VHEMkG2TMYYNUjjLc992bps"},
    {"31", "40000000", "7fffffff", "0387dc70db1806cd9a9a76637412ec11dd998be666584849b3185f7f9313c8fd28", "1LhE6sCTuGae42Axu1L1ZB7L96yi9irEBE"},
    {"32", "80000000", "ffffffff", "0209c58240e50e3ba3f833c82655e8725c037a2294e14cf5d73a5df8d56159de69", "1FRoHA9xewq7DjrZ1psWJVeTer8gHRqEvR"},
    {"33", "100000000", "1ffffffff", "03a355aa5e2e09dd44bb46a4722e9336e9e3ee4ee4e7b7a0cf5785b283bf2ab579", "187swFMjz1G54ycVU56B7jZFHFTNVQFDiu"},
    {"34", "200000000", "3ffffffff", "033cdd9d6d97cbfe7c26f902faf6a435780fe652e159ec953650ec7b1004082790", "1PWABE7oUahG2AFFQhhvViQovnCr4rEv7Q"},
    {"35", "400000000", "7ffffffff", "02f6a8148a62320e149cb15c544fe8a25ab483a0095d2280d03b8a00a7feada13d", "1PWCx5fovoEaoBowAvF5k91m2Xat9bMgwb"},
    {"36", "800000000", "fffffffff", "02b3e772216695845fa9dda419fb5daca28154d8aa59ea302f05e916635e47b9f6", "1Be2UF9NLfyLFbtm3TCbmuocc9N1Kduci1"},
    {"37", "1000000000", "1fffffffff", "027d2c03c3ef0aec70f2c7e1e75454a5dfdd0e1adea670c1b3a4643c48ad0f1255", "14iXhn8bGajVWegZHJ18vJLHhntcpL4dex"},
    {"38", "2000000000", "3fffffffff", "03c060e1e3771cbeccb38e119c2414702f3f5181a89652538851d2e3886bdd70c6", "1HBtApAFA9B2YZw3G2YKSMCtb3dVnjuNe2"},
    {"39", "4000000000", "7fffffffff", "022d77cd1467019a6bf28f7375d0949ce30e6b5815c2758b98a74c2700bc006543", "122AJhKLEfkFBaGAd84pLp1kfE7xK3GdT8"},
    {"40", "8000000000", "ffffffffff", "03a2efa402fd5268400c77c20e574ba86409ededee7c4020e4b9f0edbee53de0d4", "1EeAxcprB2PpCnr34VfZdFrkUWuxyiNEFv"},
    {"41", "10000000000", "1ffffffffff", "03b357e68437da273dcf995a474a524439faad86fc9effc300183f714b0903468b", "1L5sU9qvJeuwQUdt4y1eiLmquFxKjtHr3E"},
    {"42", "20000000000", "3ffffffffff", "03eec88385be9da803a0d6579798d977a5d0c7f80917dab49cb73c9e3927142cb6", "1E32GPWgDyeyQac4aJxm9HVoLrrEYPnM4N"},
    {"43", "40000000000", "7ffffffffff", "02a631f9ba0f28511614904df80d7f97a4f43f02249c8909dac92276ccf0bcdaed", "1PiFuqGpG8yGM5v6rNHWS3TjsG6awgEGA1"},
    {"44", "80000000000", "fffffffffff", "025e466e97ed0e7910d3d90ceb0332df48ddf67d456b9e7303b50a3d89de357336", "1CkR2uS7LmFwc3T2jV8C1BhWb5mQaoxedF"},
    {"45", "100000000000", "1fffffffffff", "026ecabd2d22fdb737be21975ce9a694e108eb94f3649c586cc7461c8abf5da71a", "1NtiLNGegHWE3Mp9g2JPkgx6wUg4TW7bbk"},
    {"46", "200000000000", "3fffffffffff", "03fd5487722d2576cb6d7081426b66a3e2986c1ce8358d479063fb5f2bb6dd5849", "1F3JRMWudBaj48EhwcHDdpeuy2jwACNxjP"},
    {"47", "400000000000", "7fffffffffff", "023a12bd3caf0b0f77bf4eea8e7a40dbe27932bf80b19ac72f5f5a64925a594196", "1Pd8VvT49sHKsmqrQiP61RsVwmXCZ6ay7Z"},
    {"48", "800000000000", "ffffffffffff", "0291bee5cf4b14c291c650732faa166040e4c18a14731f9a930c1e87d3ec12debb", "1DFYhaB2J9q1LLZJWKTnscPWos9VBqDHzv"},
    {"49", "1000000000000", "1ffffffffffff", "02591d682c3da4a2a698633bf5751738b67c343285ebdc3492645cb44658911484", "12CiUhYVTTH33w3SPUBqcpMoqnApAV4WCF"},
    {"50", "2000000000000", "3ffffffffffff", "03f46f41027bbf44fafd6b059091b900dad41e6845b2241dc3254c7cdd3c5a16c6", "1MEzite4ReNuWaL5Ds17ePKt2dCxWEofwk"},
    {"51", "4000000000000", "7ffffffffffff", "028c6c67bef9e9eebe6a513272e50c230f0f91ed560c37bc9b033241ff6c3be78f", "1NpnQyZ7x24ud82b7WiRNvPm6N8bqGQnaS"},
    {"52", "8000000000000", "fffffffffffff", "0374c33bd548ef02667d61341892134fcf216640bc2201ae61928cd0874f6314a7", "15z9c9sVpu6fwNiK7dMAFgMYSK4GqsGZim"},
    {"53", "10000000000000", "1fffffffffffff", "020faaf5f3afe58300a335874c80681cf66933e2a7aeb28387c0d28bb048bc6349", "15K1YKJMiJ4fpesTVUcByoz334rHmknxmT"},
    {"54", "20000000000000", "3fffffffffffff", "034af4b81f8c450c2c870ce1df184aff1297e5fcd54944d98d81e1a545ffb22596", "1KYUv7nSvXx4642TKeuC2SNdTk326uUpFy"},
    {"55", "40000000000000", "7fffffffffffff", "0385a30d8413af4f8f9e6312400f2d194fe14f02e719b24c3f83bf1fd233a8f963", "1LzhS3k3e9Ub8i2W1V8xQFdB8n2MYCHPCa"},
    {"56", "80000000000000", "ffffffffffffff", "033f2db2074e3217b3e5ee305301eeebb1160c4fa1e993ee280112f6348637999a", "17aPYR1m6pVAacXg1PTDDU7XafvK1dxvhi"},
    {"57", "100000000000000", "1ffffffffffffff", "02a521a07e98f78b03fc1e039bc3a51408cd73119b5eb116e583fe57dc8db07aea", "15c9mPGLku1HuW9LRtBf4jcHVpBUt8txKz"},
    {"58", "200000000000000", "3ffffffffffffff", "0311569442e870326ceec0de24eb5478c19e146ecd9d15e4666440f2f638875f42", "1Dn8NF8qDyyfHMktmuoQLGyjWmZXgvosXf"},
    {"59", "400000000000000", "7ffffffffffffff", "0241267d2d7ee1a8e76f8d1546d0d30aefb2892d231cee0dde7776daf9f8021485", "1HAX2n9Uruu9YDt4cqRgYcvtGvZj1rbUyt"},
    {"60", "800000000000000", "fffffffffffffff", "0348e843dc5b1bd246e6309b4924b81543d02b16c8083df973a89ce2c7eb89a10d", "1Kn5h2qpgw9mWE5jKpk8PP4qvvJ1QVy8su"},
    {"61", "1000000000000000", "1fffffffffffffff", "0249a43860d115143c35c09454863d6f82a95e47c1162fb9b2ebe0186eb26f453f", "1AVJKwzs9AskraJLGHAZPiaZcrpDr1U6AB"},
    {"62", "2000000000000000", "3fffffffffffffff", "03231a67e424caf7d01a00d5cd49b0464942255b8e48766f96602bdfa4ea14fea8", "1Me6EfpwZK5kQziBwBfvLiHjaPGxCKLoJi"},
    {"63", "4000000000000000", "7fffffffffffffff", "0365ec2994b8cc0a20d40dd69edfe55ca32a54bcbbaa6b0ddcff36049301a54579", "1NpYjtLira16LfGbGwZJ5JbDPh3ai9bjf4"},
    {"64", "8000000000000000", "ffffffffffffffff", "03100611c54dfef604163b8358f7b7fac13ce478e02cb224ae16d45526b25d9d4d", "16jY7qLJnxb7CHZyqBP8qca9d51gAjyXQN"},
    {"65", "10000000000000000", "1ffffffffffffffff", "0230210c23b1a047bc9bdbb13448e67deddc108946de6de639bcc75d47c0216b1b", "18ZMbwUFLMHoZBbfpCjUJQTCMCbktshgpe"},
    {"66", "20000000000000000", "3ffffffffffffffff", "null", "13zb1hQbWVsc2S7ZTZnP2G4undNNpdh5so"},
    {"67", "40000000000000000", "7ffffffffffffffff", "null", "1BY8GQbnueYofwSuFAT3USAhGjPrkxDdW9"},
    {"68", "80000000000000000", "fffffffffffffffff", "null", "1MVDYgVaSN6iKKEsbzRUAYFrYJadLYZvvZ"},
    {"69", "100000000000000000", "1fffffffffffffffff", "null", "19vkiEajfhuZ8bs8Zu2jgmC6oqZbWqhxhG"},
    {"70", "200000000000000000", "3fffffffffffffffff", "0290e6900a58d33393bc1097b5aed31f2e4e7cbd3e5466af958665bc0121248483", "19YZECXj3SxEZMoUeJ1yiPsw8xANe7M7QR"},
    {"71", "400000000000000000", "7fffffffffffffffff", "null", "1PWo3JeB9jrGwfHDNpdGK54CRas7fsVzXU"},
    {"72", "800000000000000000", "ffffffffffffffffff", "null", "1JTK7s9YVYywfm5XUH7RNhHJH1LshCaRFR"},
    {"73", "1000000000000000000", "1ffffffffffffffffff", "null", "12VVRNPi4SJqUTsp6FmqDqY5sGosDtysn4"},
    {"74", "2000000000000000000", "3ffffffffffffffffff", "null", "1FWGcVDK3JGzCC3WtkYetULPszMaK2Jksv"},
    {"75", "4000000000000000000", "7ffffffffffffffffff", "03726b574f193e374686d8e12bc6e4142adeb06770e0a2856f5e4ad89f66044755", "1J36UjUByGroXcCvmj13U6uwaVv9caEeAt"},
    {"76", "8000000000000000000", "fffffffffffffffffff", "null", "1DJh2eHFYQfACPmrvpyWc8MSTYKh7w9eRF"},
    {"77", "10000000000000000000", "1fffffffffffffffffff", "null", "1Bxk4CQdqL9p22JEtDfdXMsng1XacifUtE"},
    {"78", "20000000000000000000", "3fffffffffffffffffff", "null", "15qF6X51huDjqTmF9BJgxXdt1xcj46Jmhb"},
    {"79", "40000000000000000000", "7fffffffffffffffffff", "null", "1ARk8HWJMn8js8tQmGUJeQHjSE7KRkn2t8"},
    {"80", "80000000000000000000", "ffffffffffffffffffff", "037e1238f7b1ce757df94faa9a2eb261bf0aeb9f84dbf81212104e78931c2a19dc", "1BCf6rHUW6m3iH2ptsvnjgLruAiPQQepLe"},
    {"81", "100000000000000000000", "1ffffffffffffffffffff", "null", "15qsCm78whspNQFydGJQk5rexzxTQopnHZ"},
    {"82", "200000000000000000000", "3ffffffffffffffffffff", "null", "13zYrYhhJxp6Ui1VV7pqa5WDhNWM45ARAC"},
    {"83", "400000000000000000000", "7ffffffffffffffffffff", "null", "14MdEb4eFcT3MVG5sPFG4jGLuHJSnt1Dk2"},
    {"84", "800000000000000000000", "fffffffffffffffffffff", "null", "1CMq3SvFcVEcpLMuuH8PUcNiqsK1oicG2D"},
    {"85", "1000000000000000000000", "1fffffffffffffffffffff", "0329c4574a4fd8c810b7e42a4b398882b381bcd85e40c6883712912d167c83e73a", "1Kh22PvXERd2xpTQk3ur6pPEqFeckCJfAr"},
    {"86", "2000000000000000000000", "3fffffffffffffffffffff", "null", "1K3x5L6G57Y494fDqBfrojD28UJv4s5JcK"},
    {"87", "4000000000000000000000", "7fffffffffffffffffffff", "null", "1PxH3K1Shdjb7gSEoTX7UPDZ6SH4qGPrvq"},
    {"88", "8000000000000000000000", "ffffffffffffffffffffff", "null", "16AbnZjZZipwHMkYKBSfswGWKDmXHjEpSf"},
    {"89", "10000000000000000000000", "1ffffffffffffffffffffff", "null", "19QciEHbGVNY4hrhfKXmcBBCrJSBZ6TaVt"},
    {"90", "20000000000000000000000", "3ffffffffffffffffffffff", "035c38bd9ae4b10e8a250857006f3cfd98ab15a6196d9f4dfd25bc7ecc77d788d5", "1L12FHH2FHjvTviyanuiFVfmzCy46RRATU"},
    {"91", "40000000000000000000000", "7ffffffffffffffffffffff", "null", "1EzVHtmbN4fs4MiNk3ppEnKKhsmXYJ4s74"},
    {"92", "80000000000000000000000", "fffffffffffffffffffffff", "null", "1AE8NzzgKE7Yhz7BWtAcAAxiFMbPo82NB5"},
    {"93", "100000000000000000000000", "1fffffffffffffffffffffff", "null", "17Q7tuG2JwFFU9rXVj3uZqRtioH3mx2Jad"},
    {"94", "200000000000000000000000", "3fffffffffffffffffffffff", "null", "1K6xGMUbs6ZTXBnhw1pippqwK6wjBWtNpL"},
    {"95", "400000000000000000000000", "7fffffffffffffffffffffff", "02967a5905d6f3b420959a02789f96ab4c3223a2c4d2762f817b7895c5bc88a045", "19eVSDuizydXxhohGh8Ki9WY9KsHdSwoQC"},
    {"96", "800000000000000000000000", "ffffffffffffffffffffffff", "null", "15ANYzzCp5BFHcCnVFzXqyibpzgPLWaD8b"},
    {"97", "1000000000000000000000000", "1ffffffffffffffffffffffff", "null", "18ywPwj39nGjqBrQJSzZVq2izR12MDpDr8"},
    {"98", "2000000000000000000000000", "3ffffffffffffffffffffffff", "null", "1CaBVPrwUxbQYYswu32w7Mj4HR4maNoJSX"},
    {"99", "4000000000000000000000000", "7ffffffffffffffffffffffff", "null", "1JWnE6p6UN7ZJBN7TtcbNDoRcjFtuDWoNL"},
    {"100", "8000000000000000000000000", "fffffffffffffffffffffffff", "03d2063d40402f030d4cc71331468827aa41a8a09bd6fd801ba77fb64f8e67e617", "1KCgMv8fo2TPBpddVi9jqmMmcne9uSNJ5F"},
    {"101", "10000000000000000000000000", "1fffffffffffffffffffffffff", "null", "1CKCVdbDJasYmhswB6HKZHEAnNaDpK7W4n"},
    {"102", "20000000000000000000000000", "3fffffffffffffffffffffffff", "null", "1PXv28YxmYMaB8zxrKeZBW8dt2HK7RkRPX"},
    {"103", "40000000000000000000000000", "7fffffffffffffffffffffffff", "null", "1AcAmB6jmtU6AiEcXkmiNE9TNVPsj9DULf"},
    {"104", "80000000000000000000000000", "ffffffffffffffffffffffffff", "null", "1EQJvpsmhazYCcKX5Au6AZmZKRnzarMVZu"},
    {"105", "100000000000000000000000000", "1ffffffffffffffffffffffffff", "03bcf7ce887ffca5e62c9cabbdb7ffa71dc183c52c04ff4ee5ee82e0c55c39d77b", "1CMjscKB3QW7SDyQ4c3C3DEUHiHRhiZVib"},
    {"106", "200000000000000000000000000", "3ffffffffffffffffffffffffff", "null", "18KsfuHuzQaBTNLASyj15hy4LuqPUo1FNB"},
    {"107", "400000000000000000000000000", "7ffffffffffffffffffffffffff", "null", "15EJFC5ZTs9nhsdvSUeBXjLAuYq3SWaxTc"},
    {"108", "800000000000000000000000000", "fffffffffffffffffffffffffff", "null", "1HB1iKUqeffnVsvQsbpC6dNi1XKbyNuqao"},
    {"109", "1000000000000000000000000000", "1fffffffffffffffffffffffffff", "null", "1GvgAXVCbA8FBjXfWiAms4ytFeJcKsoyhL"},
    {"110", "2000000000000000000000000000", "3fffffffffffffffffffffffffff", "0309976ba5570966bf889196b7fdf5a0f9a1e9ab340556ec29f8bb60599616167d", "12JzYkkN76xkwvcPT6AWKZtGX6w2LAgsJg"},
    {"111", "4000000000000000000000000000", "7fffffffffffffffffffffffffff", "null", "1824ZJQ7nKJ9QFTRBqn7z7dHV5EGpzUpH3"},
    {"112", "8000000000000000000000000000", "ffffffffffffffffffffffffffff", "null", "18A7NA9FTsnJxWgkoFfPAFbQzuQxpRtCos"},
    {"113", "10000000000000000000000000000", "1ffffffffffffffffffffffffffff", "null", "1NeGn21dUDDeqFQ63xb2SpgUuXuBLA4WT4"},
    {"114", "20000000000000000000000000000", "3ffffffffffffffffffffffffffff", "null", "174SNxfqpdMGYy5YQcfLbSTK3MRNZEePoy"},
    {"115", "40000000000000000000000000000", "7ffffffffffffffffffffffffffff", "0248d313b0398d4923cdca73b8cfa6532b91b96703902fc8b32fd438a3b7cd7f55", "1NLbHuJebVwUZ1XqDjsAyfTRUPwDQbemfv"},
    {"116", "80000000000000000000000000000", "fffffffffffffffffffffffffffff", "null", "1MnJ6hdhvK37VLmqcdEwqC3iFxyWH2PHUV"},
    {"117", "100000000000000000000000000000", "1fffffffffffffffffffffffffffff", "null", "1KNRfGWw7Q9Rmwsc6NT5zsdvEb9M2Wkj5Z"},
    {"118", "200000000000000000000000000000", "3fffffffffffffffffffffffffffff", "null", "1PJZPzvGX19a7twf5HyD2VvNiPdHLzm9F6"},
    {"119", "400000000000000000000000000000", "7fffffffffffffffffffffffffffff", "null", "1GuBBhf61rnvRe4K8zu8vdQB3kHzwFqSy7"},
    {"120", "800000000000000000000000000000", "ffffffffffffffffffffffffffffff", "02ceb6cbbcdbdf5ef7150682150f4ce2c6f4807b349827dcdbdd1f2efa885a2630", "17s2b9ksz5y7abUm92cHwG8jEPCzK3dLnT"},
    {"121", "1000000000000000000000000000000", "1ffffffffffffffffffffffffffffff", "null", "1GDSuiThEV64c166LUFC9uDcVdGjqkxKyh"},
    {"122", "2000000000000000000000000000000", "3ffffffffffffffffffffffffffffff", "null", "1Me3ASYt5JCTAK2XaC32RMeH34PdprrfDx"},
    {"123", "4000000000000000000000000000000", "7ffffffffffffffffffffffffffffff", "null", "1CdufMQL892A69KXgv6UNBD17ywWqYpKut"},
    {"124", "8000000000000000000000000000000", "fffffffffffffffffffffffffffffff", "null", "1BkkGsX9ZM6iwL3zbqs7HWBV7SvosR6m8N"},
    {"125", "10000000000000000000000000000000", "1fffffffffffffffffffffffffffffff", "0233709eb11e0d4439a729f21c2c443dedb727528229713f0065721ba8fa46f00e", "1PXAyUB8ZoH3WD8n5zoAthYjN15yN5CVq5"},
    {"126", "20000000000000000000000000000000", "3fffffffffffffffffffffffffffffff", "null", "1AWCLZAjKbV1P7AHvaPNCKiB7ZWVDMxFiz"},
    {"127", "40000000000000000000000000000000", "7fffffffffffffffffffffffffffffff", "null", "1G6EFyBRU86sThN3SSt3GrHu1sA7w7nzi4"},
    {"128", "80000000000000000000000000000000", "ffffffffffffffffffffffffffffffff", "null", "1MZ2L1gFrCtkkn6DnTT2e4PFUTHw9gNwaj"},
    {"129", "100000000000000000000000000000000", "1ffffffffffffffffffffffffffffffff", "null", "1Hz3uv3nNZzBVMXLGadCucgjiCs5W9vaGz"},
    {"130", "200000000000000000000000000000000", "3ffffffffffffffffffffffffffffffff", "03633cbe3ec02b9401c5effa144c5b4d22f87940259634858fc7e59b1c09937852", "1Fo65aKq8s8iquMt6weF1rku1moWVEd5Ua"},
    {"131", "400000000000000000000000000000000", "7ffffffffffffffffffffffffffffffff", "null", "16zRPnT8znwq42q7XeMkZUhb1bKqgRogyy"},
    {"132", "800000000000000000000000000000000", "fffffffffffffffffffffffffffffffff", "null", "1KrU4dHE5WrW8rhWDsTRjR21r8t3dsrS3R"},
    {"133", "1000000000000000000000000000000000", "1fffffffffffffffffffffffffffffffff", "null", "17uDfp5r4n441xkgLFmhNoSW1KWp6xVLD"},
    {"134", "2000000000000000000000000000000000", "3fffffffffffffffffffffffffffffffff", "null", "13A3JrvXmvg5w9XGvyyR4JEJqiLz8ZySY3"},
    {"135", "4000000000000000000000000000000000", "7fffffffffffffffffffffffffffffffff", "02145d2611c823a396ef6712ce0f712f09b9b4f3135e3e0aa3230fb9b6d08d1e16", "16RGFo6hjq9ym6Pj7N5H7L1NR1rVPJyw2v"},
    {"136", "8000000000000000000000000000000000", "ffffffffffffffffffffffffffffffffff", "null", "1UDHPdovvR985NrWSkdWQDEQ1xuRiTALq"},
    {"137", "10000000000000000000000000000000000", "1ffffffffffffffffffffffffffffffffff", "null", "15nf31J46iLuK1ZkTnqHo7WgN5cARFK3RA"},
    {"138", "20000000000000000000000000000000000", "3ffffffffffffffffffffffffffffffffff", "null", "1Ab4vzG6wEQBDNQM1B2bvUz4fqXXdFk2WT"},
    {"139", "40000000000000000000000000000000000", "7ffffffffffffffffffffffffffffffffff", "null", "1Fz63c775VV9fNyj25d9Xfw3YHE6sKCxbt"},
    {"140", "80000000000000000000000000000000000", "fffffffffffffffffffffffffffffffffff", "031f6a332d3c5c4f2de2378c012f429cd109ba07d69690c6c701b6bb87860d6640", "1QKBaU6WAeycb3DbKbLBkX7vJiaS8r42Xo"},
    {"141", "100000000000000000000000000000000000", "1fffffffffffffffffffffffffffffffffff", "null", "1CD91Vm97mLQvXhrnoMChhJx4TP9MaQkJo"},
    {"142", "200000000000000000000000000000000000", "3fffffffffffffffffffffffffffffffffff", "null", "15MnK2jXPqTMURX4xC3h4mAZxyCcaWWEDD"},
    {"143", "400000000000000000000000000000000000", "7fffffffffffffffffffffffffffffffffff", "null", "13N66gCzWWHEZBxhVxG18P8wyjEWF9Yoi1"},
    {"144", "800000000000000000000000000000000000", "ffffffffffffffffffffffffffffffffffff", "null", "1NevxKDYuDcCh1ZMMi6ftmWwGrZKC6j7Ux"},
    {"145", "1000000000000000000000000000000000000", "1ffffffffffffffffffffffffffffffffffff", "03afdda497369e219a2c1c369954a930e4d3740968e5e4352475bcffce3140dae5", "19GpszRNUej5yYqxXoLnbZWKew3KdVLkXg"},
    {"146", "2000000000000000000000000000000000000", "3ffffffffffffffffffffffffffffffffffff", "null", "1M7ipcdYHey2Y5RZM34MBbpugghmjaV89P"},
    {"147", "4000000000000000000000000000000000000", "7ffffffffffffffffffffffffffffffffffff", "null", "18aNhurEAJsw6BAgtANpexk5ob1aGTwSeL"},
    {"148", "8000000000000000000000000000000000000", "fffffffffffffffffffffffffffffffffffff", "null", "1FwZXt6EpRT7Fkndzv6K4b4DFoT4trbMrV"},
    {"149", "10000000000000000000000000000000000000", "1fffffffffffffffffffffffffffffffffffff", "null", "1CXvTzR6qv8wJ7eprzUKeWxyGcHwDYP1i2"},
    {"150", "20000000000000000000000000000000000000", "3fffffffffffffffffffffffffffffffffffff", "03137807790ea7dc6e97901c2bc87411f45ed74a5629315c4e4b03a0a102250c49", "1MUJSJYtGPVGkBCTqGspnxyHahpt5Te8jy"},
    {"151", "40000000000000000000000000000000000000", "7fffffffffffffffffffffffffffffffffffff", "null", "13Q84TNNvgcL3HJiqQPvyBb9m4hxjS3jkV"},
    {"152", "80000000000000000000000000000000000000", "ffffffffffffffffffffffffffffffffffffff", "null", "1LuUHyrQr8PKSvbcY1v1PiuGuqFjWpDumN"},
    {"153", "100000000000000000000000000000000000000", "1ffffffffffffffffffffffffffffffffffffff", "null", "18192XpzzdDi2K11QVHR7td2HcPS6Qs5vg"},
    {"154", "200000000000000000000000000000000000000", "3ffffffffffffffffffffffffffffffffffffff", "null", "1NgVmsCCJaKLzGyKLFJfVequnFW9ZvnMLN"},
    {"155", "400000000000000000000000000000000000000", "7ffffffffffffffffffffffffffffffffffffff", "035cd1854cae45391ca4ec428cc7e6c7d9984424b954209a8eea197b9e364c05f6", "1AoeP37TmHdFh8uN72fu9AqgtLrUwcv2wJ"},
    {"156", "800000000000000000000000000000000000000", "fffffffffffffffffffffffffffffffffffffff", "null", "1FTpAbQa4h8trvhQXjXnmNhqdiGBd1oraE"},
    {"157", "1000000000000000000000000000000000000000", "1fffffffffffffffffffffffffffffffffffffff", "null", "14JHoRAdmJg3XR4RjMDh6Wed6ft6hzbQe9"},
    {"158", "2000000000000000000000000000000000000000", "3fffffffffffffffffffffffffffffffffffffff", "null", "19z6waranEf8CcP8FqNgdwUe1QRxvUNKBG"},
    {"159", "4000000000000000000000000000000000000000", "7fffffffffffffffffffffffffffffffffffffff", "null", "14u4nA5sugaswb6SZgn5av2vuChdMnD9E5"},
    {"160", "8000000000000000000000000000000000000000", "ffffffffffffffffffffffffffffffffffffffff", "02e0a8b039282faf6fe0fd769cfbc4b6b4cf8758ba68220eac420e32b91ddfa673", "1NBC8uXJy1GiJ6drkiZa1WuKn51ps7EPTv"},
  };

  // Lista para armazenar objetos HexRange
  public List<PuzzleClass> ranges = new ArrayList<>();

  // Construtor que inicializa a lista ranges
  public dataPuzzle(){
    // Loop para adicionar as faixas ao array de ranges
    for (String[] range : rangeData){
      int bits = Integer.parseInt(range[0]);
      String startHex = range[1];
      String endHex = range[2];
      String publicKey = range[3];
      String address = range[4];

      // Adiciona cada faixa como um objeto bbc na lista ranges
      ranges.add(new PuzzleClass(bits, startHex, endHex, publicKey, address));
    }
  }

  public static void main(String[] args){
    // Instancia a classe Puzzle e imprime os dados
    dataPuzzle puzzle = new dataPuzzle();
    puzzle.ranges.forEach(System.out::println);
  }
}