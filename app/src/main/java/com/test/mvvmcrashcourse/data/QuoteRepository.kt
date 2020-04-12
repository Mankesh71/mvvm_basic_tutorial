package com.test.mvvmcrashcourse.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuote () = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this) {
            instance ?: QuoteRepository(quoteDao = quoteDao).also { instance = it }
        }
    }

}