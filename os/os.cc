#include<bits/stdc++.h>
#include"AnsiPrint.h"
//#define BUFFER_SIZE 5
typedef int buffer_item;
using namespace std;

mutex mut;
size_t size = 0;
buffer_item buffer[ 100 ] = { 0 };
char out[ 24 ][ 81 ];
int BUFFER_SIZE;

void producer( int, size_t ), consumer( int, size_t );
int insert_item( buffer_item , int), remove_item( buffer_item& , int);

int main( int argc, char* argv[] )
{
	system("clear");
	if( argc != 5 )
	{
		printf( "Usage: %s [running time] [producer thread] [consumer thread] [buffer size]\n", *argv );
		return 1;
	}

	const size_t RUNTIME = atoi( argv[ 1 ] ), PRODUCER = atoi( argv[ 2 ] ), CONSUMER = atoi( argv[ 3 ] );
	BUFFER_SIZE = atoi( argv[ 4 ] );
	thread P[ PRODUCER ], C[ CONSUMER ];
	srand( time( NULL ) );

	for( int i = 0; i < 24; ++i )
		memset( out[ i ], ' ', 80 );
	*out[ 0 ] = *out[ 1 ] = *out[ 2 ] = *out[ 7 ] = *out[ 8 ] = *out[ 9 ] = *out[ 14 ] = *out[ 15 ] = *out[ 16 ] = *out[ 21 ] = *out[ 22 ] = *out[ 23 ] = 0;
	strcpy(out[2] , "Producer");
	strcpy( out[ 16 ] , "Consumer");
	strcpy( out[ 9 ] , "Buffer");
	for( int i = 0; i < PRODUCER ; ++i )
		for( int j = 1; j <= 4; ++j )
			out[ 3 ][ 6*i + j ] = out[ 6 ][ 6*i + j ] = '-';
	for( int i = 0; i < CONSUMER ; ++i )
		for( int j = 1; j <= 4; ++j )
			out[ 17 ][ 6*i + j ] = out[ 20 ][ 6*i + j ] = '-';
	for( int i = 0; i < BUFFER_SIZE ; ++i )
		for( int j = 1; j <= 4; ++j )
			out[ 10 ][ 6*i + j ] = out[ 13 ][ 6*i + j ] = '-';
	for( int i = 0 ; i < PRODUCER * 2 ; ++i)
		out[ 4 ][ 3 * i + 1] = out[ 5 ][ 3 * i + 1] = '|';
	for( int i = 0; i < CONSUMER * 2; ++i )
		out[ 18 ][ 3 * i + 1] = out[ 19 ][ 3 * i + 1] = '|';
	for( int i = 0; i < BUFFER_SIZE * 2; ++i )
		out[ 11 ][ 3 * i + 1] = out[ 12 ][ 3 * i + 1] = '|';
	memset( out[ 23 ] , '=' , 80 );

	for( unsigned int i = 0; i < PRODUCER; ++i )
		( P[ i ] = thread( producer, i, PRODUCER ) ).detach();
	for( unsigned int i = 0; i < CONSUMER; ++i )
		( C[ i ] = thread( consumer, i, CONSUMER ) ).detach();

	this_thread::sleep_for( chrono::seconds( RUNTIME ) );
	return 0;
}

void producer( int id, size_t producer_num )
{
	buffer_item item;
	static int *call_time = (int*) calloc( producer_num, sizeof( int ) );

	while( true )
	{
		this_thread::sleep_for( chrono::seconds( rand() % 5 + 1 ) );
		if( call_time[ id ] != *min_element( call_time, call_time + producer_num ) )
			continue;
		++call_time[ id ];
		item = rand() % 100;
		insert_item( item , id );
	}
}

int insert_item( buffer_item item  , int id)
{
	bool error = false;
	mut.lock();
		for( int i = 0 ; i < 2 ; i++ )
			out[ 4 ][ 6 * id + 2 + i ] = out[ 5 ][ 6 * id + 2 + i ] = '*';
	if( size == BUFFER_SIZE )
	{
		error = true;
		printf( "producer #%d has no space to put in buffer\n\n", id+1 );
	}
	else
	{
		for( int i = 0 ; i < 2 ; i++ )
			out[ 11 ][ 6 * size + 2 + i ] = out[ 12 ][ 6 * size + 2 + i ] = '*';
		buffer[ size++ ] = item;
		printf( "producer #%d produced one item\nBuffer now has %lu items\n", id+1, size);
	}
	for( int i = 0; i < 7; ++i )
		AnsiPrint( out[ i ] , pink , blue , true), puts( "" );
	for( int i = 7; i < 14; ++i )
		AnsiPrint( out[ i ] , yellow , blue , true), puts( "" );
	for( int i = 14; i < 23; ++i )
		AnsiPrint( out[ i ] , cyan , blue , true), puts( "" );
	AnsiPrint ( out[ 23 ] , green , black , true), puts( "" );
		for( int i = 0 ; i < 2 ; i++ )
			out[ 4 ][ 6 * id + 2 + i ] = out[ 5 ][ 6 * id + 2 + i ] = ' ';
		this_thread::sleep_for( chrono::seconds( 2 ) );
		system( "clear" );
	mut.unlock();
	return error? -1 : 0;
}

void consumer( int id, size_t consumer_num )
{
	buffer_item item;
	static int *call_time = (int*) calloc( consumer_num+1, sizeof( int ) );

	while( true )
	{
		this_thread::sleep_for( chrono::seconds( rand() % 5 + 1 ) );
		if( call_time[ id ] != *min_element( call_time, call_time + consumer_num ) )
			continue;
		++call_time[ id ];
		remove_item( item , id );
	}
	for( int i = 0 ; i < 2 ; i++ )
		out[ 18 ][ 6 * id + 2 + i ] = out[ 19 ][ 6 * id + 2 + i ] = ' ';
}

int remove_item( buffer_item& item , int id)
{
	bool error = false;
	mut.lock();
		for( int i = 0 ; i < 2 ; i++ )
			out[ 18 ][ 6 * id + 2 + i ] = out[ 19 ][ 6 * id + 2 + i ] = '*';
	if( size == 0 )
	{
		error = true;
		printf( "consumer #%d has nothing to take from buffer\n\n", id+1 );
	}
	else
	{
		item = buffer[ --size ];
		for( int i = 0 ; i < 2 ; i++ )
			out[ 11 ][ 6 * size + 2 + i ] = out[ 12 ][ 6 * size + 2 + i ] = ' ';
		printf( "consumer #%d consumed one item\nBuffer now has %lu items\n", id+1, size );
	}
	for( int i = 0; i < 7; ++i )
		AnsiPrint( out[ i ] , pink , blue , true), puts( "" );
	for( int i = 7; i < 14; ++i )
		AnsiPrint( out[ i ] , yellow , blue , true), puts( "" );
	for( int i = 14; i < 23; ++i )
		AnsiPrint( out[ i ] , cyan , blue , true), puts( "" );
	AnsiPrint ( out[ 23 ] , green , black , true), puts( "" );
	for( int i = 0 ; i < 2 ; i++ )
		out[ 18 ][ 6 * id + 2 + i ] = out[ 19 ][ 6 * id + 2 + i ] = ' ';
		this_thread::sleep_for( chrono::seconds( 2 ) );
		system( "clear" );
	mut.unlock();
	return error? -1 : 0;
}
