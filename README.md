# Windows Autocorrect

This project was initially developed to assist an individual with Primary General Dystonia. Her condition causes abnormal flexion, extension and rotation of the fingers and wrist while typing. This leads to frequent type errors, resulting in an overuse of the backspace button adding extra strain to the fifth digit of her right hand. She describes her current typing experience as extremely frustrating, tedious, and strenuous. 

The goal of this project is to alleviate some discomfort and improve her typing efficiency by providing a system wide autocorrect tool that she could use on her laptop (which happened to be a Windows system). This program is a proof-of-concept implemented in Java and uses the Levenshtein distance to provide accurate suggestions for the word being typed or misspelt. From the list of suggested words, she could simply select the desired word preventing the frequent use of the backspace button. This implementation computes the Levenshtein distance for a list of 58,000+ English words.

## Sources Used for this Project
- [Levenshtein Distance]( https://en.wikipedia.org/wiki/Levenshtein_distance) Java Implementation based on [Rosetta Stone ]( http://rosettacode.org/wiki/Levenshtein_distance#Java)
- Massive list of words English words from [here]( http://www.mieliestronk.com/wordlist.html )

## Group Members
- [Justin Prez](https://github.com/justinprez)
- [Parsa Ayani](https://github.com/Panameron)
